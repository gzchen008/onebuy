package com.xianchumo.shop.controller.weixin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xianchumo.shop.entity.Order;
import com.xianchumo.shop.entity.ShoppingCart;
import com.xianchumo.shop.service.OrderService;
import com.xianchumo.shop.service.ShoppingCartService;
import com.xianchumo.shop.util.ShopUtil;

/**
 * 
 * Copyright 2015 xianchumo.com
 * 
 * @Team xianchumo
 * @data：2015年9月20日 @author CGZ
 * @description
 */
@Controller
@RequestMapping(value="order")
public class OrderController {
	@Autowired
	private ShoppingCartService shoppingCartService;
	@Autowired
	private OrderService orderService;

	/**
	 * 下单 对应：去结算
	 */
	@RequestMapping(value = "/createOrder")
	public String createOrder(HttpServletRequest request,HttpSession session) {
		ShoppingCart shoppingCart = ShopUtil.getShoppingCart(request,shoppingCartService);
		//生成订单
		Order order = orderService.createOrder(shoppingCart);
		session.setAttribute("order", order);
		orderService.add(order);
		return "weixin/payment";
	}
	/**
	 * 付款
	 * @return
	 */
	@RequestMapping(value="pay")
	public String pay(){
		//TODO 使用微信支付
		
		return null;
	}
	/**
	 * 付款页面
	 */
	@RequestMapping(value = "/payment")
	public String payment() {
		
		return "weixin/payment";
	}

	/**
	 * 取消订单
	 */
	@RequestMapping(value = "/cancelOrder")
	public String cancelOrder(HttpSession session) {
		session.getAttribute("");
		return "index";
	}

	/**
	 * 查看历史订单
	 */
	@RequestMapping(value = "/listOrder")
	public String listOrder() {
		return "index";
	}

	/**
	 * 订单详情
	 */
	@RequestMapping(value = "/orderDetail")
	public String orderDetail() {
		return "index";
	}
}
