package com.suke.czx.modules.hladmin.service;

import com.suke.czx.modules.hladmin.entity.HlTransactionEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author czx
 * @email ${email}
 * @date 2018-06-03 13:05:01
 */
public interface HlTransactionService {
	
	HlTransactionEntity queryObject(Integer id);
	
	List<HlTransactionEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(HlTransactionEntity hlTransaction);
	
	void update(HlTransactionEntity hlTransaction);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
