package com.ddc.template.vo;

import java.io.Serializable;

/**
 * 用户和角色关系表
 * 
 * @author harry.zhang
 * @date 2018-04-27 16:57:35
 */
public class SysUserRoleVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Long id;
	/**
	 * 角色名字（对应到权限表里的角色名一定要一致）
	 */
	private String name;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 来源（1、小程序登入 2、pos登入 )
	 */
	private Integer source;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：角色名字（对应到权限表里的角色名一定要一致）
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：角色名字（对应到权限表里的角色名一定要一致）
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：来源（1、小程序登入 2、pos登入 )
	 */
	public void setSource(Integer source) {
		this.source = source;
	}
	/**
	 * 获取：来源（1、小程序登入 2、pos登入 )
	 */
	public Integer getSource() {
		return source;
	}
}
