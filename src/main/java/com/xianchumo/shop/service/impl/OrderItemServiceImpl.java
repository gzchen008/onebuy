package com.xianchumo.shop.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.xianchumo.shop.dao.BaseDao;
import com.xianchumo.shop.dao.OrderItemDao;
import com.xianchumo.shop.entity.OrderItem;
import com.xianchumo.shop.entity.OrderState;
import com.xianchumo.shop.service.OrderItemService;

public class OrderItemServiceImpl 
	extends BaseServiceImpl<OrderItem>
	implements OrderItemService{
	private OrderItemDao orderItemDao;
	@Resource(name="orderDao")
	public void setDao(BaseDao<OrderItem> dao){
		super.setDao(dao);
		orderItemDao = (OrderItemDao)dao;
	}
	@Override
	public Map<Long, Integer> orderTurnOver(Long merchantId, Date orderTime, int page) {
		//查找某个时间之前的交易成功订单
		Iterator<OrderItem> items = orderItemDao.findByMerchant(
				merchantId, orderTime, page, OrderState.SUCCESS).iterator();
				
		Map<Long, Integer> count = new HashMap<Long, Integer>(30);
		
		OrderItem item = null;
		while(items.hasNext()){
			item = items.next();
			count.put(item.getGid(),count.get(item.getGid())+ item.getAmount());
		}
		return count;
	}
}
