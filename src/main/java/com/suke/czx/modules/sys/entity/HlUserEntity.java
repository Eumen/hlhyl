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
public class HlUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	// 会员信息表
	private Integer id;
	//
	private String userName;
	//
	private String name;

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
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取：会员信息表
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置：
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	/**
	 * 获取：
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * 设置：
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * 获取：
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * 设置：
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * 获取：
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * 设置：
	 */
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	/**
	 * 获取：
	 */
	public String getBankNo() {
		return bankNo;
	}

	/**
	 * 设置：流通货币数量
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * 获取：流通货币数量
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * 设置：锁仓数量
	 */
	public void setLockAmount(Double lockAmount) {
		this.lockAmount = lockAmount;
	}

	/**
	 * 获取：锁仓数量
	 */
	public Double getLockAmount() {
		return lockAmount;
	}

	/**
	 * 设置：推荐人账号
	 */
	public void setRecUser(String recUser) {
		this.recUser = recUser;
	}

	/**
	 * 获取：推荐人账号
	 */
	public String getRecUser() {
		return recUser;
	}

	/**
	 * 设置：推荐人姓名
	 */
	public void setRecName(String recName) {
		this.recName = recName;
	}

	/**
	 * 获取：推荐人姓名
	 */
	public String getRecName() {
		return recName;
	}

	/**
	 * 设置：
	 */
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	/**
	 * 获取：
	 */
	public Date getRegisterDate() {
		return registerDate;
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
