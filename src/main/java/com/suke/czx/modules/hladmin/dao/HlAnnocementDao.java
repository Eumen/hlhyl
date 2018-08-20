package com.suke.czx.modules.hladmin.dao;

import com.suke.czx.modules.hladmin.entity.HlAnnocementEntity;
import com.suke.czx.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 华力公告
 * 
 * @author czx
 * @email ${email}
 * @date 2018-08-18 15:46:56
 */
@Mapper
public interface HlAnnocementDao extends BaseDao<HlAnnocementEntity> {
	String selectLastAnnocement();
}
