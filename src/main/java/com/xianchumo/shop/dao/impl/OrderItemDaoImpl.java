package com.xianchumo.shop.dao.impl;

import java.util.Date;
import java.util.List;

import com.xianchumo.shop.dao.OrderItemDao;
import com.xianchumo.shop.entity.OrderItem;
import com.xianchumo.shop.util.DateUtil;

import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository(value="orderItemDao")
public class OrderItemDaoImpl 
	extends BaseDaoImpl<OrderItem>
	implements OrderItemDao{
	private final int PAGE_SIZE = 15;
	@Override
	public List<OrderItem> findByMerchant(Long merchantId, Date orderTime,
			int page, Integer state) {
		StringBuilder queryString = new StringBuilder(64);
		queryString.append("FROM OrderItem AS item WHERE item.order.merchant.mid=")
				   .append(merchantId.toString())
				   .append(" AND item.order.orderTime<=\'")
				   .append(DateUtil.getInstance().dataBaseFormat(orderTime))
				   .append("\' AND item.order.orderState=")
				   .append(state.toString());
		return find(queryString.toString(), (page-1)*PAGE_SIZE, PAGE_SIZE);
	}
	
}
