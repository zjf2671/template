package com.ddc.template.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 提供给用户展示用的
 * @author harry.zhang
 *
 */
public class SysUserVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer userId;
	
	private String username;
	
	private String nickname;
	
	private String mobile;
	
	private String email;
	
	/**
	 * 当前登录店铺
	 */
	private ShopVO shopVO;
	
//	private List<Integer> companyIds;
//	
//	private List<Integer> storeIds;
//	
//	private List<Integer> shopIds; 
//	
	private List<ShopVO> shopVOList;
	
	private List<SysMenuVO> menuVOList;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
//	public List<Integer> getCompanyIds() {
//		return companyIds;
//	}
//	public void setCompanyIds(List<Integer> companyIds) {
//		this.companyIds = companyIds;
//	}
//	
//	public List<Integer> getStoreIds() {
//		return storeIds;
//	}
//	public void setStoreIds(List<Integer> storeIds) {
//		this.storeIds = storeIds;
//	}
//	
//	public List<Integer> getShopIds() {
//		return shopIds;
//	}
//	public void setShopIds(List<Integer> shopIds) {
//		this.shopIds = shopIds;
//	}
//	
	public List<ShopVO> getShopVOList() {
		return shopVOList;
	}
	public void setShopVOList(List<ShopVO> shopVOList) {
		this.shopVOList = shopVOList;
	}
	public List<SysMenuVO> getMenuVOList() {
		return menuVOList;
	}
	public void setMenuVOList(List<SysMenuVO> menuVOList) {
		this.menuVOList = menuVOList;
	}
	public ShopVO getShopVO() {
		return shopVO;
	}
	public void setShopVO(ShopVO shopVO) {
		this.shopVO = shopVO;
	}
	
}