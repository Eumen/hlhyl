package com.suke.czx.modules.hladmin.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author czx
 * @email ${email}
 * @date 2018-10-07 19:41:23
 */
public class CuxAdministrationRegionEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//行政区划代码
	private Integer regionCode;
	//行政区划名称
	private String name;
	//行政区划等级
	private Integer regionLevel;
	//上级行政区划
	private Integer parentRegionCode;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：行政区划代码
	 */
	public void setRegionCode(Integer regionCode) {
		this.regionCode = regionCode;
	}
	/**
	 * 获取：行政区划代码
	 */
	public Integer getRegionCode() {
		return regionCode;
	}
	/**
	 * 设置：行政区划名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：行政区划名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：行政区划等级
	 */
	public void setRegionLevel(Integer regionLevel) {
		this.regionLevel = regionLevel;
	}
	/**
	 * 获取：行政区划等级
	 */
	public Integer getRegionLevel() {
		return regionLevel;
	}
	/**
	 * 设置：上级行政区划
	 */
	public void setParentRegionCode(Integer parentRegionCode) {
		this.parentRegionCode = parentRegionCode;
	}
	/**
	 * 获取：上级行政区划
	 */
	public Integer getParentRegionCode() {
		return parentRegionCode;
	}
}
