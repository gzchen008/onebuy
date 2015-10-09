package com.xianchumo.shop.service;

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
	 * 创新订单
	 * @param cartItems
	 */
	Order createOrder(ShoppingCart shoppingCart);

}
