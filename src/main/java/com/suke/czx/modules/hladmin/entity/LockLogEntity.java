package com.suke.czx.modules.hladmin.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author czx
 * @email ${email}
 * @date 2018-07-25 22:29:20
 */
public class LockLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String userName;
	//
	private Double amount;
	//
	private Date lockDate;

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
	 * 设置：
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：
	 */
	public String getUserName() {
		return userName;
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
	public void setLockDate(Date lockDate) {
		this.lockDate = lockDate;
	}
	/**
	 * 获取：
	 */
	public Date getLockDate() {
		return lockDate;
	}
}
