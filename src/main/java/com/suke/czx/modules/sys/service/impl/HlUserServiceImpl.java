package com.suke.czx.modules.sys.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suke.czx.common.entity.Nodes;
import com.suke.czx.common.exception.RRException;
import com.suke.czx.common.utils.DateUtils;
import com.suke.czx.modules.hladmin.dao.HlPurchaseDao;
import com.suke.czx.modules.hladmin.dao.HlRecuserHistoryDao;
import com.suke.czx.modules.hladmin.dao.LockLogDao;
import com.suke.czx.modules.hladmin.entity.HlPurchaseEntity;
import com.suke.czx.modules.hladmin.entity.HlRecuserHistoryEntity;
import com.suke.czx.modules.hladmin.entity.LockLogEntity;
import com.suke.czx.modules.sys.dao.HlUserDao;
import com.suke.czx.modules.sys.dao.SysUserDao;
import com.suke.czx.modules.sys.dao.SysUserRoleDao;
import com.suke.czx.modules.sys.entity.HlUserEntity;
import com.suke.czx.modules.sys.entity.SysUserEntity;
import com.suke.czx.modules.sys.service.HlUserService;

@Service("hlUserService")
public class HlUserServiceImpl implements HlUserService {
	@Autowired
	private HlUserDao hlUserDao;
	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	@Autowired
	private HlPurchaseDao hlPurchaseDao;
	@Autowired
	private LockLogDao lockLogDao;

	@Autowired
	private HlRecuserHistoryDao hlRecuserHistoryDao;

	@Override
	public HlUserEntity queryObject(Integer id) {
		return hlUserDao.queryObject(id);
	}

	@Override
	public List<HlUserEntity> queryList(Map<String, Object> map) {
		return hlUserDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return hlUserDao.queryTotal(map);
	}

	@Override
	@Transactional
	public void save(HlUserEntity hlUser) {
		SysUserEntity sysUser = sysUserDao.queryByUserName(hlUser.getUserName());
		if (null != sysUser) {
			throw new RRException("此手机号已经注册！");
		}

		SysUserEntity recUser = sysUserDao.queryByUserName(hlUser.getRecUser());
		if (null == recUser) {
			throw new RRException("推荐人不存在！");
		}

		SysUserEntity savUser = new SysUserEntity();
		savUser.setUsername(hlUser.getUserName());
		// sha256加密
		String salt = RandomStringUtils.randomAlphanumeric(20);
		savUser.setPassword(new Sha256Hash(hlUser.getPassword(), salt).toHex());
		savUser.setSalt(salt);
		savUser.setName(hlUser.getName());
		savUser.setEmail("self@register.com");
		savUser.setMobile(hlUser.getTel());
		savUser.setStatus(1);
		savUser.setCreateTime(new Date());
		savUser.setCreateUserId(0L);
		savUser.setDePassword(hlUser.getPassword());
		sysUserDao.save(savUser);

		hlUser.setRecName(recUser.getName());
		hlUser.setRegisterDate(new Date());
		hlUserDao.save(hlUser);

		// 生成角色表
		Map<String, Object> map = new HashMap<>();
		map.put("userId", savUser.getUserId());
		List<Long> list = new ArrayList<Long>();
		list.add(1L);
		map.put("roleIdList", list);
		sysUserRoleDao.save(map);
	}

	@Override
	public void update(HlUserEntity hlUser) {
		hlUserDao.update(hlUser);
	}

	@Override
	@Transactional
	public void lock(HlUserEntity hlUser, Double willLockAmount) {
		hlUserDao.update(hlUser);
		LockLogEntity lock = new LockLogEntity();
		lock.setUserName(hlUser.getUserName());
		lock.setAmount(willLockAmount);
		lock.setLockDate(new Date());
		lockLogDao.save(lock);
	}

	@Override
	public void delete(Integer id) {
		hlUserDao.delete(id);
	}

	@Override
	public void deleteBatch(Integer[] ids) {
		hlUserDao.deleteBatch(ids);
	}

	@Override
	public Nodes getAllUserMap(String userName) {
		List<HlUserEntity> allUser = this.hlUserDao.queryAll();
		Nodes nodes = new Nodes();
		nodes.setUserNode(this.getUserByUserName(allUser, userName));
		this.buildChildren(allUser, nodes.getUserNode().getUserName(), nodes);

		// 业绩统计
		// 取每个部门的负责人
		List<HlUserEntity> departmentUser = this.getAllChildren(allUser, userName);
		Map<String, List<HlUserEntity>> achieveMem = new HashMap<String, List<HlUserEntity>>();
		if (CollectionUtils.isNotEmpty(departmentUser)) {
			List<HlUserEntity> allChildren;
			for (HlUserEntity hlUserEntity : departmentUser) {
				allChildren = new ArrayList<HlUserEntity>();
				this.getAllChildrenNodes(allUser, hlUserEntity.getUserName(), allChildren);
				achieveMem.put(hlUserEntity.getUserName(), allChildren);
			}
		}

		List<HlPurchaseEntity> totalAmount = this.hlPurchaseDao.queryAmountGroupByUserName();
		achieveMem.forEach((key, value) -> {
			double departAmount = 0;
			for (HlUserEntity user : value) {
				for (HlPurchaseEntity userAmount : totalAmount) {
					if (user.getUserName().equals(userAmount.getUserName())) {
						departAmount += userAmount.getAmount();
					}
				}
			}
			nodes.getAchievement().put(key, departAmount);
		});

		return nodes;
	}

	private HlUserEntity getUserByUserName(List<HlUserEntity> allUser, String userName) {
		Optional<HlUserEntity> stream = allUser.stream().filter(user -> user.getUserName().equals(userName))
				.findFirst();
		if (!stream.isPresent()) {
			throw new RRException("用户不存在");
		}
		return stream.get();
	}

	private boolean hasChild(List<HlUserEntity> allUser, String userName) {
		return allUser.stream().filter(user -> user.getRecUser().equals(userName)).count() > 0 ? true : false;
	}

	private List<HlUserEntity> getAllChildren(List<HlUserEntity> allUser, String userName) {
		return allUser.stream().filter(user -> user.getRecUser().equals(userName)).collect(Collectors.toList());
	}

	private void getAllChildrenNodes(List<HlUserEntity> allUser, String userName, List<HlUserEntity> allChildren) {
		if (this.hasChild(allUser, userName)) {
			List<HlUserEntity> children = this.getAllChildren(allUser, userName);
			allChildren.addAll(children);
			for (HlUserEntity hlUserEntity : children) {
				this.getAllChildrenNodes(allUser, hlUserEntity.getUserName(), allChildren);
			}
		}
	}

	private void buildChildren(List<HlUserEntity> allUser, String userName, Nodes nodes) {
		if (this.hasChild(allUser, userName)) {
			List<HlUserEntity> children = this.getAllChildren(allUser, userName);
			for (HlUserEntity hlUserEntity : children) {
				Nodes childNode = new Nodes();
				childNode.setUserNode(hlUserEntity);
				this.buildChildren(allUser, childNode.getUserNode().getUserName(), childNode);
				nodes.getChildren().add(childNode);
			}
		}
	}

	@Override
	public void password(int userId) {
		HlUserEntity userEntity = this.hlUserDao.queryObject(userId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", userEntity.getUserName());
		List<SysUserEntity> listSysUser = this.sysUserDao.queryList(map);
		SysUserEntity sysUser = listSysUser.get(0);
		sysUser.setSalt(sysUser.getSalt());
		sysUser.setPassword(new Sha256Hash("112233", sysUser.getSalt()).toHex());
		sysUser.setDePassword("112233");
		this.sysUserDao.update(sysUser);
	}

	@Override
	@Transactional
	public void modifyRecUser(int id, String recNewUserName, String recNewName) {
		HlUserEntity user = this.hlUserDao.queryObject(id);
		HlRecuserHistoryEntity hre = new HlRecuserHistoryEntity();
		hre.setUserName(user.getUserName());
		hre.setName(user.getName());
		hre.setRecUserName(user.getRecUser());
		hre.setRecName(user.getRecName());
		hre.setRecNewUserName(recNewUserName);
		hre.setRecNewName(recNewName);
		hre.setComments(DateUtils.format(new Date(), "yyyy-mm-dd"));
		hlRecuserHistoryDao.save(hre);
		user.setRecUser(recNewUserName);
		user.setRecName(recNewName);
		this.hlUserDao.update(user);
	}

}
