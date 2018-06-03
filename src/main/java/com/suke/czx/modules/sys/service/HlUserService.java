package com.suke.czx.modules.sys.service;

import com.suke.czx.modules.sys.entity.HlUserEntity;

import java.util.List;
import java.util.Map;

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
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
