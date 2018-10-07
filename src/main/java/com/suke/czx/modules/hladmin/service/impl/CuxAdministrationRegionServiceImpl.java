package com.suke.czx.modules.hladmin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.suke.czx.modules.hladmin.dao.CuxAdministrationRegionDao;
import com.suke.czx.modules.hladmin.entity.CuxAdministrationRegionEntity;
import com.suke.czx.modules.hladmin.service.CuxAdministrationRegionService;



@Service("cuxAdministrationRegionService")
public class CuxAdministrationRegionServiceImpl implements CuxAdministrationRegionService {
	@Autowired
	private CuxAdministrationRegionDao cuxAdministrationRegionDao;
	
	@Override
	public CuxAdministrationRegionEntity queryObject(Integer id){
		return cuxAdministrationRegionDao.queryObject(id);
	}
	
	@Override
	public List<CuxAdministrationRegionEntity> queryList(Map<String, Object> map){
		return cuxAdministrationRegionDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return cuxAdministrationRegionDao.queryTotal(map);
	}
	
	@Override
	public void save(CuxAdministrationRegionEntity cuxAdministrationRegion){
		cuxAdministrationRegionDao.save(cuxAdministrationRegion);
	}
	
	@Override
	public void update(CuxAdministrationRegionEntity cuxAdministrationRegion){
		cuxAdministrationRegionDao.update(cuxAdministrationRegion);
	}
	
	@Override
	public void delete(Integer id){
		cuxAdministrationRegionDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		cuxAdministrationRegionDao.deleteBatch(ids);
	}
	
}
