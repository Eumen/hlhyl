package com.suke.czx.modules.hladmin.service;

import com.suke.czx.modules.hladmin.entity.HlRecuserHistoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 推荐人修改记录
 * 
 * @author czx
 * @email ${email}
 * @date 2018-08-18 15:46:56
 */
public interface HlRecuserHistoryService {
	
	HlRecuserHistoryEntity queryObject(Integer id);
	
	List<HlRecuserHistoryEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(HlRecuserHistoryEntity hlRecuserHistory);
	
	void update(HlRecuserHistoryEntity hlRecuserHistory);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
