package com.suke.czx.modules.hladmin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 华力公告
 * 
 * @author czx
 * @email ${email}
 * @date 2018-08-18 15:46:56
 */
public class HlAnnocementEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Integer id;
	// 公告内容
	private String content;
	// 经办人
	private String operatorName;
	// 经办日期
	private Date operatorDate;

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
	 * 设置：公告内容
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 获取：公告内容
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置：经办人
	 */
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	/**
	 * 获取：经办人
	 */
	public String getOperatorName() {
		return operatorName;
	}

	/**
	 * 设置：经办日期
	 */
	public void setOperatorDate(Date operatorDate) {
		this.operatorDate = operatorDate;
	}

	/**
	 * 获取：经办日期
	 */
	public Date getOperatorDate() {
		return operatorDate;
	}
}
