package com.suke.czx.modules.hladmin.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suke.czx.common.utils.RangeUtils;
import com.suke.czx.modules.hladmin.dao.HlRewardDao;
import com.suke.czx.modules.hladmin.entity.HlRewardEntity;
import com.suke.czx.modules.hladmin.service.HlRewardService;
import com.suke.czx.modules.sys.dao.HlUserDao;
import com.suke.czx.modules.sys.entity.HlUserEntity;

@Service("hlRewardService")
public class HlRewardServiceImpl implements HlRewardService {
	@Autowired
	private HlRewardDao hlRewardDao;

	@Autowired
	private HlUserDao hlUserDao;

	@Override
	public HlRewardEntity queryObject(Integer id) {
		return hlRewardDao.queryObject(id);
	}

	@Override
	public List<HlRewardEntity> queryList(Map<String, Object> map) {
		return hlRewardDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return hlRewardDao.queryTotal(map);
	}

	@Override
	public void save(HlRewardEntity hlReward) {
		hlRewardDao.save(hlReward);
	}

	@Override
	public void update(HlRewardEntity hlReward) {
		hlRewardDao.update(hlReward);
	}

	@Override
	public void delete(Integer id) {
		hlRewardDao.delete(id);
	}

	@Override
	public void deleteBatch(Integer[] ids) {
		hlRewardDao.deleteBatch(ids);
	}

	@Override
	@Transactional
	public void generate() {
		List<HlUserEntity> listUser = hlUserDao.queryList(null);
		listUser.stream().filter(user -> user.getLockAmount() > 0.0).forEach(user -> {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userName", user.getUserName());
			map.put("awardType", "1");
			int count = hlRewardDao.queryTotal(map);
			if (count % 60 == 0 && count > 0) {
				user.setAmount(user.getAmount() + user.getLockAmount());
				user.setLockAmount(0.0d);
				hlUserDao.update(user);
			} else {
				double award = user.getLockAmount() * RangeUtils.lockRange(user.getLockAmount());
				user.setAmount(user.getAmount() + award);
				hlUserDao.update(user);

				HlRewardEntity hre = new HlRewardEntity();
				hre.setAmount(award);
				hre.setUserName(user.getUserName());
				hre.setName(user.getName());
				hre.setAwardDate(new Date());
				hre.setAwardType(1);
				hre.setComment("锁仓奖金");
				hlRewardDao.save(hre);
			}
		});
	}

	@Override
	public int isGenerate(String awardDate) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("awardDate", awardDate);
		return hlRewardDao.isGenerate(map);
	}

}
