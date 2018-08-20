package com.suke.czx.modules.hladmin.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 推荐人修改记录
 * 
 * @author czx
 * @email ${email}
 * @date 2018-08-18 15:46:56
 */
public class HlRecuserHistoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//用户名
	private String userName;
	//姓名
	private String name;
	//原推荐人账号
	private String recUserName;
	//原推荐人姓名
	private String recName;
	//现推荐人账号
	private String recNewUserName;
	//现在用户姓名
	private String recNewName;
	//注释
	private String comments;

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
	 * 设置：用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：用户名
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
	 * 设置：原推荐人账号
	 */
	public void setRecUserName(String recUserName) {
		this.recUserName = recUserName;
	}
	/**
	 * 获取：原推荐人账号
	 */
	public String getRecUserName() {
		return recUserName;
	}
	/**
	 * 设置：原推荐人姓名
	 */
	public void setRecName(String recName) {
		this.recName = recName;
	}
	/**
	 * 获取：原推荐人姓名
	 */
	public String getRecName() {
		return recName;
	}
	/**
	 * 设置：现推荐人账号
	 */
	public void setRecNewUserName(String recNewUserName) {
		this.recNewUserName = recNewUserName;
	}
	/**
	 * 获取：现推荐人账号
	 */
	public String getRecNewUserName() {
		return recNewUserName;
	}
	/**
	 * 设置：现在用户姓名
	 */
	public void setRecNewName(String recNewName) {
		this.recNewName = recNewName;
	}
	/**
	 * 获取：现在用户姓名
	 */
	public String getRecNewName() {
		return recNewName;
	}
	/**
	 * 设置：注释
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	/**
	 * 获取：注释
	 */
	public String getComments() {
		return comments;
	}
}
