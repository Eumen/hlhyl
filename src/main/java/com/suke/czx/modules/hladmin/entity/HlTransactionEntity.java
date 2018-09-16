package com.suke.czx.modules.hladmin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author czx
 * @email ${email}
 * @date 2018-06-04 22:36:46
 */
@SuppressWarnings("serial")
public class HlTransactionEntity implements Serializable {

	// 会员交易明细表
	private Integer id;
	// 用户登陆名
	private String userName;
	// 姓名
	private String name;
	// 转账账号
	private String targetUserName;
	// 转账姓名
	private String targetName;
	// 交易类型： 1. 对私交易， 2. 对公交易
	private Integer type;
	// 交易数量
	private Double amount;
	// 对公账户收取手续费
	private Double realAmount;
	//
	private Date tranDate;
	
	private String price;
	//
	private String comment;

	/**
	 * 设置：会员交易明细表
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取：会员交易明细表
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置：用户登陆名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 获取：用户登陆名
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置：转账账号
	 */
	public void setTargetUserName(String targetUserName) {
		this.targetUserName = targetUserName;
	}

	/**
	 * 获取：转账账号
	 */
	public String getTargetUserName() {
		return targetUserName;
	}

	/**
	 * 设置：转账姓名
	 */
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

	/**
	 * 获取：转账姓名
	 */
	public String getTargetName() {
		return targetName;
	}

	/**
	 * 设置：交易类型： 1. 对私交易， 2. 对公交易
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 获取：交易类型： 1. 对私交易， 2. 对公交易
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 设置：交易数量
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * 获取：交易数量
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * 设置：对公账户收取手续费
	 */
	public void setRealAmount(Double realAmount) {
		this.realAmount = realAmount;
	}

	/**
	 * 获取：对公账户收取手续费
	 */
	public Double getRealAmount() {
		return realAmount;
	}

	/**
	 * 设置：
	 */
	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}

	/**
	 * 获取：
	 */
	public Date getTranDate() {
		return tranDate;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * 设置：
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * 获取：
	 */
	public String getComment() {
		return comment;
	}
}
