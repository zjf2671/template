package com.ddc.template.vo;

import java.io.Serializable;

public class SysMenuVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String menuName;
	
	private Integer menuId;
	
	private String path;
	
	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
