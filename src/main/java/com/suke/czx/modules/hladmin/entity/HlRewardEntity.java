package com.suke.czx.modules.hladmin.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author czx
 * @email ${email}
 * @date 2018-06-03 13:09:22
 */
public class HlRewardEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//会员奖金明细表
	private Integer id;
	//用户登陆名
	private String userName;
	//姓名
	private String name;
	//
	private Double amount;
	//
	private Date awardDate;
	//1. 锁仓奖励2. 直推奖励
	private Integer awardType;
	//
	private String comment;

	/**
	 * 设置：会员奖金明细表
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：会员奖金明细表
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
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	/**
	 * 获取：
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * 设置：
	 */
	public void setAwardDate(Date awardDate) {
		this.awardDate = awardDate;
	}
	/**
	 * 获取：
	 */
	public Date getAwardDate() {
		return awardDate;
	}
	/**
	 * 设置：1. 锁仓奖励2. 直推奖励
	 */
	public void setAwardType(Integer awardType) {
		this.awardType = awardType;
	}
	/**
	 * 获取：1. 锁仓奖励2. 直推奖励
	 */
	public Integer getAwardType() {
		return awardType;
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
