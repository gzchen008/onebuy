package com.vanroid.onebuy.common;

import java.util.List;
import java.util.Map;


/**
 * @author kaiscript 2015年8月2日 下午5:13:26
 */
public class Pager {

	/**
	 * 排序方式（递增、递减）
	 */
	public enum Order {
		asc, desc
	}
	
	private Map<String,Order> orderMap;
	/**
	 * 每页记录
	 */
	private int pageSize;
	/**
	 * 当前页码
	 */
	private int pageIndex;
	/**
	 * 总记录数
	 */
	private int totalCount;
	/**
	 * 总页数
	 */
	private int totalPage;
	/**
	 * 排序
	 */
	private Order order;
	/**
	 * 数据结果
	 */
	private List<?> datas;
	/**
	 * 是否有下一页
	 */
	private boolean hasNextPage;
	/**
	 * 是否有上一页
	 */
	private boolean hasPreviousPage;

	public void init() {

		previousPage();
		nextPage();
		totalPage();
	}

	/**
	 * 初始化 总页数
	 */
	public void totalPage() {
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}

	}

	/**
	 * 初始化 是否有上一页 参数 hasPreviousPage
	 */
	public void previousPage() {
		if (pageIndex == 1) {
			hasPreviousPage = false;
		} else {
			hasPreviousPage = true;
		}
	}

	/**
	 * 初始化 是否有下一页 参数 hasNextPage
	 */
	public void nextPage() {
		if (pageIndex == totalPage) {
			hasNextPage = false;
		} else {
			hasNextPage = true;
		}
	}

	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	
	public Map<String, Order> getOrderMap() {
		return orderMap;
	}

	public void setOrderMap(Map<String, Order> orderMap) {
		this.orderMap = orderMap;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<?> getDatas() {
		return datas;
	}

	public void setDatas(List<?> datas) {
		this.datas = datas;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

}
