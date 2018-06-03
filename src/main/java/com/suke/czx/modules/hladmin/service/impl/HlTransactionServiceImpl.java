package com.suke.czx.modules.hladmin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.suke.czx.modules.hladmin.dao.HlTransactionDao;
import com.suke.czx.modules.hladmin.entity.HlTransactionEntity;
import com.suke.czx.modules.hladmin.service.HlTransactionService;



@Service("hlTransactionService")
public class HlTransactionServiceImpl implements HlTransactionService {
	@Autowired
	private HlTransactionDao hlTransactionDao;
	
	@Override
	public HlTransactionEntity queryObject(Integer id){
		return hlTransactionDao.queryObject(id);
	}
	
	@Override
	public List<HlTransactionEntity> queryList(Map<String, Object> map){
		return hlTransactionDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return hlTransactionDao.queryTotal(map);
	}
	
	@Override
	public void save(HlTransactionEntity hlTransaction){
		hlTransactionDao.save(hlTransaction);
	}
	
	@Override
	public void update(HlTransactionEntity hlTransaction){
		hlTransactionDao.update(hlTransaction);
	}
	
	@Override
	public void delete(Integer id){
		hlTransactionDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		hlTransactionDao.deleteBatch(ids);
	}
	
}
