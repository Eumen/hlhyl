package com.suke.czx.modules.hladmin.service;

import com.suke.czx.modules.hladmin.entity.HlPurchaseEntity;

import java.util.List;
import java.util.Map;

/**
 * 购买货币申请
 * 
 * @author czx
 * @email ${email}
 * @date 2018-06-02 16:15:34
 */
public interface HlPurchaseService {
	
	HlPurchaseEntity queryObject(Integer id);
	
	List<HlPurchaseEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(HlPurchaseEntity hlPurchase);
	
	void update(HlPurchaseEntity hlPurchase);
	
	void audit(HlPurchaseEntity hlPurchase);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
