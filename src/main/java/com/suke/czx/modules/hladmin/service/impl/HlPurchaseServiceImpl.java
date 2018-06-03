package com.suke.czx.modules.hladmin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.suke.czx.modules.hladmin.dao.HlPurchaseDao;
import com.suke.czx.modules.hladmin.entity.HlPurchaseEntity;
import com.suke.czx.modules.hladmin.service.HlPurchaseService;



@Service("hlPurchaseService")
public class HlPurchaseServiceImpl implements HlPurchaseService {
	@Autowired
	private HlPurchaseDao hlPurchaseDao;
	
	@Override
	public HlPurchaseEntity queryObject(Integer id){
		return hlPurchaseDao.queryObject(id);
	}
	
	@Override
	public List<HlPurchaseEntity> queryList(Map<String, Object> map){
		return hlPurchaseDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return hlPurchaseDao.queryTotal(map);
	}
	
	@Override
	public void save(HlPurchaseEntity hlPurchase){
		hlPurchaseDao.save(hlPurchase);
	}
	
	@Override
	public void update(HlPurchaseEntity hlPurchase){
		hlPurchaseDao.update(hlPurchase);
	}
	
	@Override
	public void delete(Integer id){
		hlPurchaseDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		hlPurchaseDao.deleteBatch(ids);
	}
	
}
