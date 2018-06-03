package com.suke.czx.modules.hladmin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.suke.czx.modules.hladmin.dao.HlRewardDao;
import com.suke.czx.modules.hladmin.entity.HlRewardEntity;
import com.suke.czx.modules.hladmin.service.HlRewardService;



@Service("hlRewardService")
public class HlRewardServiceImpl implements HlRewardService {
	@Autowired
	private HlRewardDao hlRewardDao;
	
	@Override
	public HlRewardEntity queryObject(Integer id){
		return hlRewardDao.queryObject(id);
	}
	
	@Override
	public List<HlRewardEntity> queryList(Map<String, Object> map){
		return hlRewardDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return hlRewardDao.queryTotal(map);
	}
	
	@Override
	public void save(HlRewardEntity hlReward){
		hlRewardDao.save(hlReward);
	}
	
	@Override
	public void update(HlRewardEntity hlReward){
		hlRewardDao.update(hlReward);
	}
	
	@Override
	public void delete(Integer id){
		hlRewardDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		hlRewardDao.deleteBatch(ids);
	}
	
}
