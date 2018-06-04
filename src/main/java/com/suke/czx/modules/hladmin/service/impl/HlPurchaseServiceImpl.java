package com.suke.czx.modules.hladmin.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.suke.czx.common.utils.RangeUtils;
import com.suke.czx.modules.hladmin.dao.HlPurchaseDao;
import com.suke.czx.modules.hladmin.dao.HlRewardDao;
import com.suke.czx.modules.hladmin.entity.HlPurchaseEntity;
import com.suke.czx.modules.hladmin.entity.HlRewardEntity;
import com.suke.czx.modules.hladmin.service.HlPurchaseService;
import com.suke.czx.modules.sys.dao.HlUserDao;
import com.suke.czx.modules.sys.entity.HlUserEntity;

@Service("hlPurchaseService")
public class HlPurchaseServiceImpl implements HlPurchaseService {
	@Autowired
	private HlPurchaseDao hlPurchaseDao;

	@Autowired
	private HlUserDao hlUserDao;

	@Autowired
	private HlRewardDao hlRewardDao;

	@Override
	public HlPurchaseEntity queryObject(Integer id) {
		return hlPurchaseDao.queryObject(id);
	}

	@Override
	public List<HlPurchaseEntity> queryList(Map<String, Object> map) {
		return hlPurchaseDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return hlPurchaseDao.queryTotal(map);
	}

	@Override
	public void save(HlPurchaseEntity hlPurchase) {
		hlPurchaseDao.save(hlPurchase);
	}

	@Override
	public void update(HlPurchaseEntity hlPurchase) {
		hlPurchaseDao.update(hlPurchase);
	}

	@Override
	public void delete(Integer id) {
		hlPurchaseDao.delete(id);
	}

	@Override
	public void deleteBatch(Integer[] ids) {
		hlPurchaseDao.deleteBatch(ids);
	}

	@Override
	@Transactional
	public void audit(HlPurchaseEntity hlPurchase) {
		hlPurchaseDao.update(hlPurchase);
		String userName = hlPurchase.getUserName();
		Map<String, String> userMap = new HashMap<String, String>();
		userMap.put("userName", userName);
		List<HlUserEntity> userList = hlUserDao.queryList(userMap);
		if (!StringUtils.isEmpty(userList)) {

			HlUserEntity ownUser = userList.get(0);
			ownUser.setAmount(ownUser.getAmount() + hlPurchase.getAmount());
			hlUserDao.update(ownUser);
			
			Map<String, String> recMap = new HashMap<String, String>();
			recMap.put("userName", userList.get(0).getRecUser());
			List<HlUserEntity> recUserList = hlUserDao.queryList(recMap);
			if (!StringUtils.isEmpty(recUserList)) {
				
				HlUserEntity recUser = recUserList.get(0);
				if (recUserList.get(0).getLockAmount() > 0) {
					HlUserEntity user = userList.get(0);
					HlRewardEntity hre = new HlRewardEntity();
					hre.setUserName(user.getRecUser());
					hre.setName(user.getRecName());
					hre.setAwardDate(new Date());
					hre.setAwardType(2);
					// 投资金额 * 推荐人锁仓金额所求的百分比
					double recAward = hlPurchase.getAmount() * RangeUtils.recRange(recUserList.get(0).getLockAmount());
					hre.setAmount(recAward);
					hre.setComment("推荐用户" + hlPurchase.getName() + "直接奖金");
					hlRewardDao.save(hre);
					
					// 更新推荐人账户流通资金
					recUser.setAmount(recUser.getAmount() + recAward);
					hlUserDao.update(recUser);
				}
			}
		}
	}

}
