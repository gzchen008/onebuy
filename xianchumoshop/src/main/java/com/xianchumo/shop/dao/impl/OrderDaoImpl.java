package com.xianchumo.shop.dao.impl;

import org.springframework.stereotype.Repository;

import com.xianchumo.shop.dao.OrderDao;
import com.xianchumo.shop.entity.Order;
@SuppressWarnings("unchecked")
@Repository(value="orderDao")
public class OrderDaoImpl extends BaseDaoImpl<Order> 
	implements OrderDao{


	
}
