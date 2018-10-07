package com.suke.czx.modules.hladmin.service;

import com.suke.czx.modules.hladmin.entity.CuxAdministrationRegionEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author czx
 * @email ${email}
 * @date 2018-10-07 19:41:23
 */
public interface CuxAdministrationRegionService {
	
	CuxAdministrationRegionEntity queryObject(Integer id);
	
	List<CuxAdministrationRegionEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CuxAdministrationRegionEntity cuxAdministrationRegion);
	
	void update(CuxAdministrationRegionEntity cuxAdministrationRegion);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
