package com.suke.czx.modules.hladmin.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author czx
 * @email ${email}
 * @date 2018-06-03 13:05:01
 */
public class HlTransactionEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//会员交易明细表
	private Integer id;
	//用户登陆名
	private String userName;
	//姓名
	private String name;
	//
	private Integer recUserId;
	//
	private String recUserName;
	//交易类型： 1. 对私交易， 2. 对公交易
	private Integer type;
	//交易数量
	private Double amount;
	//对公账户收取手续费
	private Double realAmount;
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
	 * 设置：
	 */
	public void setRecUserId(Integer recUserId) {
		this.recUserId = recUserId;
	}
	/**
	 * 获取：
	 */
	public Integer getRecUserId() {
		return recUserId;
	}
	/**
	 * 设置：
	 */
	public void setRecUserName(String recUserName) {
		this.recUserName = recUserName;
	}
	/**
	 * 获取：
	 */
	public String getRecUserName() {
		return recUserName;
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
