package com.xianchumo.shop.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xianchumo.shop.dao.BaseDao;
import com.xianchumo.shop.entity.Merchant;
import com.xianchumo.shop.entity.Order;
import com.xianchumo.shop.entity.OrderState;
import com.xianchumo.shop.entity.ShoppingCart;
import com.xianchumo.shop.service.OrderService;
import com.xianchumo.shop.util.ShopUtil;
/**
 * 
 * Copyright 2015 xianchumo.com
 * @Team xianchumo
 * @data：2015年9月19日
 * @author CGZ
 * @description
 */
@Service("orderService")
@Transactional
public class OrderServiceImpl extends BaseServiceImpl<Order>
	implements OrderService{
	@Resource(name="orderDao")
	public void setDao(BaseDao<Order> dao){
		super.setDao(dao);
	}

	@Override
	public Order createOrder(ShoppingCart shoppingCart) {
		//生成订单号
		String orderNumber = ShopUtil.createOrderNumber();
		Order order = new Order();
		order.setOrderNumber(orderNumber);
		order.setMoney(shoppingCart.getTotal());
		order.setGoods(ShopUtil.cartItem2OrderItem(order,shoppingCart.getCartItems()));
		order.setOrderState(OrderState.GENERATE);
		order.setUser(shoppingCart.getUser());
		//网点
		//TODO
		Merchant merchant = new Merchant();
		merchant.setMid(1l);
		order.setMerchant(merchant);
		
		order.setOrderTime(new Date());
		dao.save(order);
		return order;
	}
}
