package com.suke.czx.modules.sys.service;

import java.util.List;
import java.util.Map;

import com.suke.czx.common.entity.Nodes;
import com.suke.czx.modules.sys.entity.HlUserEntity;

/**
 * 
 * 
 * @author czx
 * @email ${email}
 * @date 2018-06-02 12:49:13
 */
public interface HlUserService {

	HlUserEntity queryObject(Integer id);

	List<HlUserEntity> queryList(Map<String, Object> map);

	int queryTotal(Map<String, Object> map);

	void save(HlUserEntity hlUser);

	void update(HlUserEntity hlUser);
	
	void lock(HlUserEntity hlUser, Double willLockAmount);

	void delete(Integer id);

	void deleteBatch(Integer[] ids);
	
	void password(int userId);

	Nodes getAllUserMap(String userName);
}
