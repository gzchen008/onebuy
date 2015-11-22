package com.xianchumo.shop.service;

import java.util.Date;
import java.util.Map;

import com.xianchumo.shop.entity.OrderItem;

public interface OrderItemService extends BaseService<OrderItem>{
	/**
	 * 统计销售数量
	 * @param merchantId
	 * @param orderTime
	 * @param page
	 * @return
	 */
	public Map<Long, Integer> orderTurnOver(Long merchantId, Date orderTime, int page);
}
