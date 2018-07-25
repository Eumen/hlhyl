package com.suke.czx.modules.hladmin.dao;

import com.suke.czx.modules.hladmin.entity.HlTransactionEntity;
import com.suke.czx.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author czx
 * @email ${email}
 * @date 2018-06-04 22:36:46
 */
@Mapper
public interface HlTransactionDao extends BaseDao<HlTransactionEntity> {
	int querySumWeekByUserName(String userName);
}
