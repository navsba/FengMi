package com.fengmiwang.util;

public class PageAssistant {

	private int dataCount;		// 数据总条数
	private int pageSize;		// 页容量
	private int currentPageNo;	// 当前页码
	private int pageCount;		// 总页数

	public int getDataCount() {
		return dataCount;
	}

	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public int getPageCount() {
		if (dataCount % pageSize == 0) {
			this.pageCount = dataCount / pageSize;
		} else {
			this.pageCount = dataCount / pageSize + 1;
		}
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
}
