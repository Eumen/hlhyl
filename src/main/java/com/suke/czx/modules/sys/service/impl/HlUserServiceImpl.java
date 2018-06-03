package com.suke.czx.modules.sys.service.impl;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.suke.czx.common.exception.RRException;
import com.suke.czx.modules.sys.dao.HlUserDao;
import com.suke.czx.modules.sys.dao.SysUserDao;
import com.suke.czx.modules.sys.dao.SysUserRoleDao;
import com.suke.czx.modules.sys.entity.HlUserEntity;
import com.suke.czx.modules.sys.entity.SysRoleEntity;
import com.suke.czx.modules.sys.entity.SysUserEntity;
import com.suke.czx.modules.sys.entity.SysUserRoleEntity;
import com.suke.czx.modules.sys.service.HlUserService;



@Service("hlUserService")
public class HlUserServiceImpl implements HlUserService {
	@Autowired
	private HlUserDao hlUserDao;
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	
	@Override
	public HlUserEntity queryObject(Integer id){
		return hlUserDao.queryObject(id);
	}
	
	@Override
	public List<HlUserEntity> queryList(Map<String, Object> map){
		return hlUserDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return hlUserDao.queryTotal(map);
	}
	
	@Override
	@Transactional
	public void save(HlUserEntity hlUser){
		SysUserEntity sysUser = sysUserDao.queryByUserName(hlUser.getUserName());
		if(null != sysUser){
			throw new RRException("此手机号已经注册！");
		}
		
		SysUserEntity recUser = sysUserDao.queryByUserName(hlUser.getRecUser());
		if(null == recUser){
			throw new RRException("推荐人不存在！");
		}
		
		SysUserEntity savUser = new SysUserEntity();
		savUser.setUsername(hlUser.getUserName());
		//sha256加密
		String salt = RandomStringUtils.randomAlphanumeric(20);
		savUser.setPassword(new Sha256Hash(hlUser.getPassword(), salt).toHex());
		savUser.setSalt(salt);
		savUser.setName(hlUser.getName());
		savUser.setEmail("self@register.com");
		savUser.setMobile(hlUser.getTel());
		savUser.setStatus(1);
		savUser.setCreateTime(new Date());
		savUser.setCreateUserId(0L);
		sysUserDao.save(savUser);
		
		hlUser.setRecName(recUser.getName());
		hlUser.setRegisterDate(new Date());
		hlUserDao.save(hlUser);
		
		//  生成角色表
		Map<String, Object> map = new HashMap<>();
		map.put("userId", savUser.getUserId());
		List<Long> list = new ArrayList<Long>();
		list.add(1L);
		map.put("roleIdList", list);
		sysUserRoleDao.save(map);
	}
	
	@Override
	public void update(HlUserEntity hlUser){
		hlUserDao.update(hlUser);
	}
	
	@Override
	public void delete(Integer id){
		hlUserDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		hlUserDao.deleteBatch(ids);
	}
	
}
