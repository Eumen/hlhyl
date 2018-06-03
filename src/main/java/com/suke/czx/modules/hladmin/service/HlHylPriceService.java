package com.suke.czx.modules.hladmin.service;

import com.suke.czx.modules.hladmin.entity.HlHylPriceEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-06-02 10:04:01
 */
public interface HlHylPriceService {
	
	HlHylPriceEntity queryObject(Integer id);
	
	List<HlHylPriceEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(HlHylPriceEntity hlHylPrice);
	
	void update(HlHylPriceEntity hlHylPrice);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
