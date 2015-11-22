package com.xianchumo.shop.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.xianchumo.shop.dao.OrderDao;
import com.xianchumo.shop.entity.Order;
import com.xianchumo.shop.entity.ShoppingCart;
@SuppressWarnings("unchecked")
@Repository(value="orderDao")
public class OrderDaoImpl extends BaseDaoImpl<Order> 
	implements OrderDao{
	public static int PAGE_SIZE = 20;
	@Override
	public List<Order> findByMerchant(Long merchantId, int page) {
		StringBuilder queryString = new StringBuilder(64);
		queryString.append("FROM Order AS order WHERE order.merchant.mid=")
				   .append(merchantId.toString());
		return find(queryString.toString(), (page-1)*PAGE_SIZE, PAGE_SIZE);
	}

	@Override
	public List<Order> findByMerchantAndState(Long merchantId, int state,
			int page) {
		StringBuilder queryString = new StringBuilder();
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
	public List<Order> findOrder(int page) {
		return find("FROM Order", 
				(page-1)*PAGE_SIZE, PAGE_SIZE);
	}

	@Override
	public List<Order> findByOrderTime(Date startTime, Date endTime, int page) {
		StringBuilder queryString = new StringBuilder();
		if(startTime == null){
			queryString.append("FROM Order WHERE orderTime<=")
			           .append(endTime);
		}else{
			queryString.append("FROM Order WHERE orderTime>=")
	           .append(startTime)
	           .append(" AND orderTime<=")
	           .append(endTime);
		}
		return find(queryString.toString(), 
				(page-1)*PAGE_SIZE, PAGE_SIZE);
	}

	@Override
	public List<Order> findByUser(String phone, int page) {
		return find("FROM Order AS order WHERE order.user.phone="+phone, 
				(page-1)*PAGE_SIZE, PAGE_SIZE);
	}

	@Override
	public List<Order> findByUserAndTime(String phone, Date startTime,
			Date endTime, int page) {
		StringBuilder queryString = new StringBuilder();
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
		return find(queryString.toString(),
				(page-1)*PAGE_SIZE, PAGE_SIZE);
	}

	
	
}
