package com.suke.czx.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author czx
 * @email ${email}
 * @date 2018-06-02 12:49:13
 */
@SuppressWarnings("serial")
public class HlUserEntity implements Serializable {
	// 会员信息表
	private Integer id;
	//
	private String userName;
	//
	private String name;

	private String dePassword;

	private String password;
	//
	private String idCard;
	//
	private String tel;
	//
	private String bankName;
	//
	private String bankNo;
	// 流通货币数量
	private Double amount;
	// 锁仓数量
	private Double lockAmount;
	// 推荐人账号
	private String recUser;
	// 推荐人姓名
	private String recName;
	//
	private Date registerDate;
	//
	private String comment;

	/**
	 * 设置：会员信息表
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * 获取：会员信息表
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * 设置：
	 */
	public void setUserName(final String userName) {
		this.userName = userName;
	}

	/**
	 * 获取：
	 */
	public String getUserName() {
		return this.userName;
	}

	public String getDePassword() {
		return dePassword;
	}

	public void setDePassword(String dePassword) {
		this.dePassword = dePassword;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * 设置：
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * 获取：
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 设置：
	 */
	public void setIdCard(final String idCard) {
		this.idCard = idCard;
	}

	/**
	 * 获取：
	 */
	public String getIdCard() {
		return this.idCard;
	}

	/**
	 * 设置：
	 */
	public void setTel(final String tel) {
		this.tel = tel;
	}

	/**
	 * 获取：
	 */
	public String getTel() {
		return this.tel;
	}

	/**
	 * 设置：
	 */
	public void setBankName(final String bankName) {
		this.bankName = bankName;
	}

	/**
	 * 获取：
	 */
	public String getBankName() {
		return this.bankName;
	}

	/**
	 * 设置：
	 */
	public void setBankNo(final String bankNo) {
		this.bankNo = bankNo;
	}

	/**
	 * 获取：
	 */
	public String getBankNo() {
		return this.bankNo;
	}

	/**
	 * 设置：流通货币数量
	 */
	public void setAmount(final Double amount) {
		this.amount = amount;
	}

	/**
	 * 获取：流通货币数量
	 */
	public Double getAmount() {
		return this.amount;
	}

	/**
	 * 设置：锁仓数量
	 */
	public void setLockAmount(final Double lockAmount) {
		this.lockAmount = lockAmount;
	}

	/**
	 * 获取：锁仓数量
	 */
	public Double getLockAmount() {
		return this.lockAmount;
	}

	/**
	 * 设置：推荐人账号
	 */
	public void setRecUser(final String recUser) {
		this.recUser = recUser;
	}

	/**
	 * 获取：推荐人账号
	 */
	public String getRecUser() {
		return this.recUser;
	}

	/**
	 * 设置：推荐人姓名
	 */
	public void setRecName(final String recName) {
		this.recName = recName;
	}

	/**
	 * 获取：推荐人姓名
	 */
	public String getRecName() {
		return this.recName;
	}

	/**
	 * 设置：
	 */
	public void setRegisterDate(final Date registerDate) {
		this.registerDate = registerDate;
	}

	/**
	 * 获取：
	 */
	public Date getRegisterDate() {
		return this.registerDate;
	}

	/**
	 * 设置：
	 */
	public void setComment(final String comment) {
		this.comment = comment;
	}

	/**
	 * 获取：
	 */
	public String getComment() {
		return this.comment;
	}
}
