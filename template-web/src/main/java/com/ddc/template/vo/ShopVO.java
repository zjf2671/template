package com.ddc.template.vo;

import java.io.Serializable;
import java.util.Date;

public class ShopVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	/**
	 * 店铺名称
	 */
	private String shopName;
	/**
	 * 所属门店id
	 */
	private Long storeId;
	
	/**
	 * 门店名 冗余字段     exist = false
	 */
	private String storeName;
	/**
	 * 店铺类型（1、DDC  2、入驻商家）
	 */
	private Integer shopType;
	/**
	 * 所属公司id
	 */
	private Long companyId;
	
	/**
	 * 所属公司名称  冗余字段
	 */
	private String companyName;
	/**
	 * 开店时间
	 */
	private Date shopTime;
	/**
	 * 经营状态（1、营业 2、停业）
	 */
	private Integer status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Long getStoreId() {
		return storeId;
	}
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public Integer getShopType() {
		return shopType;
	}
	public void setShopType(Integer shopType) {
		this.shopType = shopType;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Date getShopTime() {
		return shopTime;
	}
	public void setShopTime(Date shopTime) {
		this.shopTime = shopTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	

}
