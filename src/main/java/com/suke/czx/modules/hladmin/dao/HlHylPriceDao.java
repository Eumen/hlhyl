package com.suke.czx.modules.hladmin.dao;

import com.suke.czx.modules.hladmin.entity.HlHylPriceEntity;
import com.suke.czx.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-06-02 10:04:01
 */
@Mapper
public interface HlHylPriceDao extends BaseDao<HlHylPriceEntity> {
	String queryMaxPrice();
}
