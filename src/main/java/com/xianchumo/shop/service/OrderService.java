package com.xianchumo.shop.service;

import java.util.List;

import com.xianchumo.shop.entity.Order;
import com.xianchumo.shop.entity.ShoppingCart;
/**
 * 
 * Copyright 2015 xianchumo.com
 * @Team xianchumo
 * @data：2015年9月19日
 * @author CGZ
 * @description
 */
public interface OrderService extends BaseService<Order>{
	/**
	 * 根据商家id查找对应的定单，每次查询20条
	 * @param merchantId
	 * @param page
	 * @return
	 */
	public List<Order> findByMerchant(Long merchantId, int page);
	/**
	 * 根据商家的id和订单的状态进行查询
	 * @param merchantId
	 * @param state
	 * @param page
	 * @return
	 */
	public List<Order> findByMerchantAndState(Long merchantId, int state, int page);
	/**
	 * 创新订单
	 * @param cartItems
	 */
	Order createOrder(ShoppingCart shoppingCart);

}
