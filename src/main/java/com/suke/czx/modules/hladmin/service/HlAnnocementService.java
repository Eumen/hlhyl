package com.suke.czx.modules.hladmin.service;

import com.suke.czx.modules.hladmin.entity.HlAnnocementEntity;

import java.util.List;
import java.util.Map;

/**
 * 华力公告
 * 
 * @author czx
 * @email ${email}
 * @date 2018-08-18 15:46:56
 */
public interface HlAnnocementService {
	
	HlAnnocementEntity queryObject(Integer id);
	
	List<HlAnnocementEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(HlAnnocementEntity hlAnnocement);
	
	void update(HlAnnocementEntity hlAnnocement);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
	
	String selectLastAnnocement();
}
