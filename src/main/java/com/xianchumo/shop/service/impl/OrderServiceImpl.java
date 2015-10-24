package com.xianchumo.shop.service.impl;

import java.util.Date;
import java.util.List;

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
	public static int PAGE = 20;
	@Resource(name="orderDao")
	public void setDao(BaseDao<Order> dao){
		super.setDao(dao);
	}
	

	@Override
	public List<Order> findByMerchant(Long merchantId, int page) {
		String queryString = "FROM Order AS order WHERE order.merchant.mid="
							.concat(String.valueOf(merchantId));
		return this.dao.find(queryString, PAGE*page, PAGE);
	}

	@Override
	public List<Order> findByMerchantAndState(Long merchantId, int state,
			int page) {
		StringBuilder queryString = new StringBuilder();
		queryString.append("FROM Order AS order WHERE order.merchant.mid=")
				   .append(merchantId)
				   .append(" AND orderState=")
				   .append(state);
		return this.dao.find(queryString.toString(), page*PAGE, PAGE);
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
