package com.xianchumo.shop.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.vanroid.weixin.pojo.PageObj;
import com.xianchumo.shop.dao.OrderDao;
import com.xianchumo.shop.entity.Order;
import com.xianchumo.shop.util.InfoUtil;
@SuppressWarnings("unchecked")
@Repository(value="orderDao")
public class OrderDaoImpl extends BaseDaoImpl<Order> 
	implements OrderDao{
	public final int PAGE_SIZE = 20;
	@Override
	public List<Order> findByMerchant(Long merchantId, int page) {
		StringBuilder queryString = new StringBuilder(64);
		queryString.append("FROM Order AS order WHERE order.merchant.mid=")
				   .append(merchantId.toString());
		return find(queryString.toString(), (page-1)*PAGE_SIZE, PAGE_SIZE);
	}

	@Override
	public List<Order> findRecordByMerchant(Long merchantId, int page) {
		StringBuilder queryString = new StringBuilder(64);
		queryString.append("FROM Order AS order WHERE order.merchant.mid=")
				   .append(merchantId.toString())
				   .append(" AND orderState>=4");
		return find(queryString.toString(), (page-1)*PAGE_SIZE, PAGE_SIZE);
	}
	
	@Override
	public List<Order> findByDateAndState(Long merchantId, Date orderTime, int page, Integer state) {
		StringBuilder queryString = new StringBuilder(64);
		queryString.append("FROM Order AS order WHERE order.merchant.mid=")
				   .append(merchantId.toString())
				   .append(" AND orderTime<=\'")
				   .append(orderTime)
				   .append("\' AND orderState=")
				   .append(state.toString());
		return find(queryString.toString(), (page-1)*PAGE_SIZE, PAGE_SIZE);
	}

	@Override
	public List<Order> findByMerchantAndState(Long merchantId, int state,
			int page) {
		StringBuilder queryString = new StringBuilder(64);
		queryString.append("FROM Order AS order WHERE order.merchant.mid=")
				   .append(merchantId.toString());
	   //state:1代表未处理的订单，2代表已处理的订单
	   if(state==1){
		   queryString.append(" AND orderState<=2");
	   }else{
		   queryString.append(" AND orderState>2");
	   }
		return find(queryString.toString(), 
				(page-1)*PAGE_SIZE, PAGE_SIZE);
	}


	@Override
	public PageObj<Order> findOrder(int page) {
		Long totalCount = totalCount();
		if(totalCount == 0){
			return null;
		}
		List<Order> orders = find("FROM Order", (page-1)*PAGE_SIZE, PAGE_SIZE);
		if(orders != null && orders.size() != 0){
			return new PageObj(orders, totalCount, PAGE_SIZE, page);
		}
		return null;
	}

	@Override
	public PageObj<Order> findByOrderTime(Date startTime, Date endTime, int page) {
		StringBuilder totalQuery = new StringBuilder(64);
		if(startTime == null){
			totalQuery.append("select count(oid) from Order where orderTime<=")
			           .append(endTime);
		}else{
			totalQuery.append("select count(oid) from Order where  orderTime>=")
	           .append(startTime)
	           .append(" adn orderTime<=")
	           .append(endTime);
		}
		Long totalCount = totalCount(totalQuery.toString());
		if(totalCount != 0){
			StringBuilder queryString = new StringBuilder(64);
			if(startTime == null){
				queryString.append("FROM Order WHERE orderTime<=")
				           .append(endTime);
			}else{
				queryString.append("FROM Order WHERE orderTime>=")
		           .append(startTime)
		           .append(" AND orderTime<=")
		           .append(endTime);
			}
			List<Order> orders = find(queryString.toString(), 
										(page-1)*PAGE_SIZE, PAGE_SIZE);
			if(orders != null && orders.size() != 0){
				return new PageObj<Order>(orders, totalCount, PAGE_SIZE, page);
			}	
		}
		return null;
	}

	@Override
	public PageObj<Order> findByUser(String phone, int page) {
		StringBuilder totalQuery = new StringBuilder(
				"select count(oid) from Order as order where order.user.phone=");
		totalQuery.append(phone);
		Long totalCount = totalCount(totalQuery.toString());
		if(totalCount != 0){
			StringBuilder queryString = new StringBuilder(
					"from Order as order where order.user.phone=");
			queryString.append(phone);
			List<Order> list = find(queryString.toString(),
					(page-1)*PAGE_SIZE, PAGE_SIZE);
			if(list != null && list.size() != 0){
				return new PageObj<Order>(list, totalCount, PAGE_SIZE, page);
			}
		}
		return null;
	}

	@Override
	public PageObj<Order> findByUserAndTime(String phone, Date startTime,
			Date endTime, int page) {
		StringBuilder totalQuery = new StringBuilder(64);
		if(startTime == null){
			totalQuery.append("select count(oid) from Order as order where order.user.phone=")
					   .append(phone)
					   .append(" and orderTime<=")
			           .append(endTime);
		}else{
			totalQuery.append("from Order as order where  order.user.phone=")
			   .append(phone)
			   .append(" and orderTime>=")
	           .append(startTime)
	           .append(" and orderTime<=")
	           .append(endTime);
		}
		//获取查询结果总数量
		Long totalCount = totalCount(totalQuery.toString());
		if(totalCount != 0){
			StringBuilder queryString = new StringBuilder(64);
			if(startTime == null){
				queryString.append("FROM Order AS order WHERE order.user.phone=")
						   .append(phone)
						   .append(" AND orderTime<=")
				           .append(endTime);
			}else{
				queryString.append("FROM Order AS order WHERE order.user.phone=")
				   .append(phone)
				   .append(" AND orderTime>=")
		           .append(startTime)
		           .append(" AND orderTime<=")
		           .append(endTime);
			}
			List<Order> orders = find(queryString.toString(),
										(page-1)*PAGE_SIZE, PAGE_SIZE);
			if(orders != null && orders.size() != 0){
				return new PageObj<Order>(orders, totalCount, PAGE_SIZE, page);
			}
		}
		return null;
	}

	
	
}
