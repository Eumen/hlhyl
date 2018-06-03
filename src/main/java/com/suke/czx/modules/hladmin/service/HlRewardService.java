package com.suke.czx.modules.hladmin.service;

import com.suke.czx.modules.hladmin.entity.HlRewardEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author czx
 * @email ${email}
 * @date 2018-06-03 13:05:01
 */
public interface HlRewardService {
	
	HlRewardEntity queryObject(Integer id);
	
	List<HlRewardEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(HlRewardEntity hlReward);
	
	void update(HlRewardEntity hlReward);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
