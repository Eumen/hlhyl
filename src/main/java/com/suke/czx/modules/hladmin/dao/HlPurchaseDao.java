package com.suke.czx.modules.hladmin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.suke.czx.modules.hladmin.entity.HlPurchaseEntity;
import com.suke.czx.modules.sys.dao.BaseDao;

/**
 * 购买货币申请
 * 
 * @author czx
 * @email ${email}
 * @date 2018-06-02 16:15:34
 */
@Mapper
public interface HlPurchaseDao extends BaseDao<HlPurchaseEntity> {
	List<HlPurchaseEntity> queryAmountGroupByUserName();
}
