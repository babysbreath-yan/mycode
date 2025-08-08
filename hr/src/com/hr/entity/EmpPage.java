package com.hr.entity;
//分页处理
public class EmpPage {
	private int pageSize;//每页显示几条数据
	private int dataCount;//一共有多少条数据
	private int pageCount;//总页数
	private int pageIndex;//当前在第几页
	public EmpPage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpPage(int pageSize, int dataCount, int pageCount, int pageIndex) {
		super();
		this.pageSize = pageSize;
		this.dataCount = dataCount;
		this.pageCount = pageCount;
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getDataCount() {
		return dataCount;
	}
	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	

}
