package com.suke.czx.modules.hladmin.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suke.czx.modules.hladmin.dao.HlTransactionDao;
import com.suke.czx.modules.hladmin.entity.HlTransactionEntity;
import com.suke.czx.modules.hladmin.service.HlTransactionService;
import com.suke.czx.modules.sys.dao.HlUserDao;
import com.suke.czx.modules.sys.entity.HlUserEntity;

@Service("hlTransactionService")
public class HlTransactionServiceImpl implements HlTransactionService {
	@Autowired
	private HlTransactionDao hlTransactionDao;
	@Autowired
	private HlUserDao hlUserDao;

	@Override
	public HlTransactionEntity queryObject(Integer id) {
		return hlTransactionDao.queryObject(id);
	}

	@Override
	public List<HlTransactionEntity> queryList(Map<String, Object> map) {
		return hlTransactionDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return hlTransactionDao.queryTotal(map);
	}

	@Transactional
	@Override
	public void save(HlTransactionEntity hlTransaction) {
		Map<String, Object> ownMap = new HashMap<String, Object>();
		ownMap.put("userName", hlTransaction.getUserName());
		List<HlUserEntity> listOwnUser = hlUserDao.queryList(ownMap);
		if (listOwnUser.size() > 0) {
			HlUserEntity ownUser = listOwnUser.get(0);
			ownUser.setAmount(ownUser.getAmount() - hlTransaction.getAmount());
			hlUserDao.update(ownUser);
		}
		Map<String, Object> targetMap = new HashMap<String, Object>();
		targetMap.put("userName", hlTransaction.getTargetUserName());
		List<HlUserEntity> listTargetUser = hlUserDao.queryList(targetMap);
		if (listTargetUser.size() > 0) {
			HlUserEntity targetUser = listTargetUser.get(0);
			targetUser.setAmount(targetUser.getAmount() + hlTransaction.getAmount());
			hlUserDao.update(targetUser);
		}

		hlTransaction.setTranDate(new Date());
		if (1 != hlTransaction.getType()) {
			hlTransaction.setRealAmount(hlTransaction.getAmount() * 0.85);
		} else {
			hlTransaction.setRealAmount(hlTransaction.getAmount());
		}
		hlTransactionDao.save(hlTransaction);
	}

	@Override
	public void update(HlTransactionEntity hlTransaction) {
		hlTransactionDao.update(hlTransaction);
	}

	@Override
	public void delete(Integer id) {
		hlTransactionDao.delete(id);
	}

	@Override
	public void deleteBatch(Integer[] ids) {
		hlTransactionDao.deleteBatch(ids);
	}

}
