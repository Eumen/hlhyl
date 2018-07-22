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
@SuppressWarnings("serial")
public class HlPurchaseEntity implements Serializable {

	// 货币购买明细表
	private Integer id;
	// 登陆名
	private String userName;
	// 用户姓名
	private String name;
	// 购买数量
	private Integer amount;
	// 购买状态： 1. 申请 2. 已购买
	private Integer status;
	// 申请日期
	private Date applyDate;
	// 支付方式
	private Integer payApproach;
	// 实付金额
	private Double realPay;
	// 审核日期
	private Date purchaseDate;
	// 备注
	private String comment;

	/**
	 * 设置：货币购买明细表
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * 获取：货币购买明细表
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * 设置：登陆名
	 */
	public void setUserName(final String userName) {
		this.userName = userName;
	}

	/**
	 * 获取：登陆名
	 */
	public String getUserName() {
		return this.userName;
	}

	/**
	 * 设置：用户姓名
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * 获取：用户姓名
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 设置：购买数量
	 */
	public void setAmount(final Integer amount) {
		this.amount = amount;
	}

	/**
	 * 获取：购买数量
	 */
	public Integer getAmount() {
		return this.amount;
	}

	/**
	 * 设置：购买状态： 1. 申请 2. 已购买
	 */
	public void setStatus(final Integer status) {
		this.status = status;
	}

	/**
	 * 获取：购买状态： 1. 申请 2. 已购买
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * 设置：申请日期
	 */
	public void setApplyDate(final Date applyDate) {
		this.applyDate = applyDate;
	}

	/**
	 * 获取：申请日期
	 */
	public Date getApplyDate() {
		return this.applyDate;
	}

	/**
	 * 设置： 审核日期
	 */
	public void setPurchaseDate(final Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	/**
	 * 获取： 审核日期
	 */
	public Date getPurchaseDate() {
		return this.purchaseDate;
	}

	public Integer getPayApproach() {
		return this.payApproach;
	}

	public void setPayApproach(final Integer payApproach) {
		this.payApproach = payApproach;
	}

	public Double getRealPay() {
		return this.realPay;
	}

	public void setRealPay(final Double realPay) {
		this.realPay = realPay;
	}

	/**
	 * 设置：备注
	 */
	public void setComment(final String comment) {
		this.comment = comment;
	}

	/**
	 * 获取：备注
	 */
	public String getComment() {
		return this.comment;
	}
}
