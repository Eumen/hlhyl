package com.suke.czx.modules.hladmin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.suke.czx.modules.hladmin.dao.HlRecuserHistoryDao;
import com.suke.czx.modules.hladmin.entity.HlRecuserHistoryEntity;
import com.suke.czx.modules.hladmin.service.HlRecuserHistoryService;



@Service("hlRecuserHistoryService")
public class HlRecuserHistoryServiceImpl implements HlRecuserHistoryService {
	@Autowired
	private HlRecuserHistoryDao hlRecuserHistoryDao;
	
	@Override
	public HlRecuserHistoryEntity queryObject(Integer id){
		return hlRecuserHistoryDao.queryObject(id);
	}
	
	@Override
	public List<HlRecuserHistoryEntity> queryList(Map<String, Object> map){
		return hlRecuserHistoryDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return hlRecuserHistoryDao.queryTotal(map);
	}
	
	@Override
	public void save(HlRecuserHistoryEntity hlRecuserHistory){
		hlRecuserHistoryDao.save(hlRecuserHistory);
	}
	
	@Override
	public void update(HlRecuserHistoryEntity hlRecuserHistory){
		hlRecuserHistoryDao.update(hlRecuserHistory);
	}
	
	@Override
	public void delete(Integer id){
		hlRecuserHistoryDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		hlRecuserHistoryDao.deleteBatch(ids);
	}
	
}
