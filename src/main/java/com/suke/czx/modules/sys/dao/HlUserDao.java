package com.suke.czx.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.suke.czx.modules.sys.entity.HlUserEntity;

/**
 * 
 * 
 * @author czx
 * @email ${email}
 * @date 2018-06-02 12:49:13
 */
@Mapper
public interface HlUserDao extends BaseDao<HlUserEntity> {
	List<HlUserEntity> queryAll();
}
