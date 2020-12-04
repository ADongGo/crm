package cn.offcn.utils;

import java.util.List;

public class PageView<T> {
	
	private Long  totalPage;
	private int   currentPage=1;
	private int   pageSize=10;
	private Long  totalrecords;
	private List<T> records;
	
	public PageView(){}
	public PageView(int currentPage,int pageSize){
		this.currentPage=currentPage;
		this.pageSize=pageSize;
	}
	public Long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public Long getTotalrecords() {
		return totalrecords;
	}
	public void setTotalrecords(Long totalrecords) {
		this.totalrecords = totalrecords;
		this.totalPage=this.totalrecords%this.pageSize==0? this.totalrecords/this.pageSize : this.totalrecords/this.pageSize+1;
	}
	
	public List<T> getRecords() {
		return records;
	}
	public void setRecords(List<T> records) {
		this.records = records;
	}
	
	

}
