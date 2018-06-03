package com.suke.czx.modules.hladmin.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2018-06-02 10:04:01
 */
public class HlHylPriceEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//货币每日价格表
	private Integer id;
	//
	private Double price;
	//
	private Date priceDate;
	//
	private String comment;

	/**
	 * 设置：货币每日价格表
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：货币每日价格表
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * 获取：
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * 设置：
	 */
	public void setPriceDate(Date priceDate) {
		this.priceDate = priceDate;
	}
	/**
	 * 获取：
	 */
	public Date getPriceDate() {
		return priceDate;
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
