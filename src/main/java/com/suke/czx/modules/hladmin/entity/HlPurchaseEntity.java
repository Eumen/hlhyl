package com.suke.czx.modules.hladmin.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 购买货币申请
 * 
 * @author czx
 * @email ${email}
 * @date 2018-06-02 16:15:34
 */
public class HlPurchaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//货币购买明细表
	private Integer id;
	//登陆名
	private String userName;
	//用户姓名
	private String name;
	//购买数量
	private Integer amount;
	//购买状态： 1. 申请   2. 已购买
	private Integer status;
	//申请日期
	private Date applyDate;
	// 审核日期
	private Date purchaseDate;
	//备注
	private String comment;

	/**
	 * 设置：货币购买明细表
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：货币购买明细表
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：登陆名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：登陆名
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：用户姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：用户姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：购买数量
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	/**
	 * 获取：购买数量
	 */
	public Integer getAmount() {
		return amount;
	}
	/**
	 * 设置：购买状态： 1. 申请   2. 已购买
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：购买状态： 1. 申请   2. 已购买
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：申请日期
	 */
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	/**
	 * 获取：申请日期
	 */
	public Date getApplyDate() {
		return applyDate;
	}
	/**
	 * 设置： 审核日期
	 */
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	/**
	 * 获取： 审核日期
	 */
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	/**
	 * 设置：备注
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * 获取：备注
	 */
	public String getComment() {
		return comment;
	}
}
