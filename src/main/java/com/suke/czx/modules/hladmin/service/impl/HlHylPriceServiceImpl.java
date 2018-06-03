package com.suke.czx.modules.hladmin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.suke.czx.modules.hladmin.dao.HlHylPriceDao;
import com.suke.czx.modules.hladmin.entity.HlHylPriceEntity;
import com.suke.czx.modules.hladmin.service.HlHylPriceService;



@Service("hlHylPriceService")
public class HlHylPriceServiceImpl implements HlHylPriceService {
	@Autowired
	private HlHylPriceDao hlHylPriceDao;
	
	@Override
	public HlHylPriceEntity queryObject(Integer id){
		return hlHylPriceDao.queryObject(id);
	}
	
	@Override
	public List<HlHylPriceEntity> queryList(Map<String, Object> map){
		return hlHylPriceDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return hlHylPriceDao.queryTotal(map);
	}
	
	@Override
	public void save(HlHylPriceEntity hlHylPrice){
		hlHylPrice.setPriceDate(new Date());
		hlHylPriceDao.save(hlHylPrice);
	}
	
	@Override
	public void update(HlHylPriceEntity hlHylPrice){
		hlHylPriceDao.update(hlHylPrice);
	}
	
	@Override
	public void delete(Integer id){
		hlHylPriceDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		hlHylPriceDao.deleteBatch(ids);
	}
	
}
