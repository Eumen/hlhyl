package com.suke.czx.modules.hladmin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.suke.czx.modules.hladmin.entity.HlRewardEntity;
import com.suke.czx.modules.sys.dao.BaseDao;

/**
 * 
 * 
 * @author czx
 * @email ${email}
 * @date 2018-06-03 13:05:01
 */
@Mapper
public interface HlRewardDao extends BaseDao<HlRewardEntity> {
	int isGenerate(Map<String, String> map);
	
	void saveBatch(List<HlRewardEntity> awardList);
}
