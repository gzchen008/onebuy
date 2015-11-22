package com.xianchumo.shop.dao;

import java.util.Date;
import java.util.List;

import com.xianchumo.shop.entity.OrderItem;

public interface OrderItemDao extends BaseDao<OrderItem>{
	public List<OrderItem> findByMerchant(Long merchantId,
			Date orderTime, int page, Integer state);
}
