package com.vanroid.weixin.pojo;

import java.util.List;

import com.xianchumo.shop.util.InfoUtil;
/**
 * 需要分页显示的对象
 * @author yangtk
 *
 * @param <T>
 */
public class PageObj<T> {
	//分页list表
	private List<T> list;
	//查询总数
	private long totalCount;
	//页大小
	private int pageSize;
	//上一页
	private int prePage;
	//当前页
	private int nowPage;
	//下一页
	private int nextPage;
	//页数
	private Long pageCount;
	public PageObj(){}
	
	public PageObj(List<T> list, long totalCount, int pageSize, int nowPage) {
		super();
		this.list = list;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.nowPage = nowPage;
		this.prePage = nowPage-1;
		this.nextPage = nowPage+1;
		this.pageCount = InfoUtil.getPageCount(totalCount, pageSize);
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPrePage() {
		return prePage;
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public Long getPageCount() {
		return pageCount;
	}
	public void setPageCount(Long pageCount) {
		this.pageCount = pageCount;
	}
}
