package com.ddc.template.model;

import java.io.Serializable;

/**
 * 分页参数
 * @author harry.zhang
 *
 */
public class Pagination implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 当前页码
	 */
	private int currPage = 1;
	/**
	 * 每页条数
	 */
	private int pageSize = 10;
	
	/**
	 * 排序字段
	 */
	private String sidx;
	
	/**
	 *  排序方式，如：asc、desc
	 */
	private String order;
	
	/**
	 * 开始查询标记
	 */
	private int limitStart = 0;
	
	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public int getLimitStart() {
		return this.currPage != 1 ? (this.currPage-1) * this.pageSize : this.limitStart;
	}

	public void setLimitStart(int limitStart) {
		this.limitStart = limitStart;
	}

}
