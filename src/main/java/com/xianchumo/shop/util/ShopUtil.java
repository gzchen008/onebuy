package com.xianchumo.shop.util;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.xianchumo.shop.entity.CartItem;
import com.xianchumo.shop.entity.Grade;
import com.xianchumo.shop.entity.Order;
import com.xianchumo.shop.entity.OrderItem;
import com.xianchumo.shop.entity.ShoppingCart;
import com.xianchumo.shop.entity.User;
import com.xianchumo.shop.entity.Wallet;
import com.xianchumo.shop.service.ShoppingCartService;

/**
 * 
 * Copyright 2015 xianchumo.com
 * 
 * @Team xianchumo
 * @data：2015年10月2日 @author CGZ
 * @description 商店工具类
 */
public class ShopUtil {

	/**
	 * 使用httpRequest获取购物车
	 * 
	 * @param httpRequest
	 * @return
	 */
	public static ShoppingCart getShoppingCart(HttpServletRequest httpRequest,ShoppingCartService shoppingCartService) {
		User user = (User) httpRequest.getSession().getAttribute("user");
		ShoppingCart shoppingCart = user.getShoppingCart();
		if (shoppingCart == null) {
			System.out.println("创建shoppingcart");
			shoppingCart = new ShoppingCart();
			user.setShoppingCart(shoppingCart);
		}else{
			shoppingCart = shoppingCartService.get(shoppingCart.getSid());
			user.setShoppingCart(shoppingCart);
		}
		shoppingCart.setUser(user);
		httpRequest.getSession().setAttribute("shoppingCart", shoppingCart);
		return shoppingCart;
	}

	public synchronized static String createOrderNumber() {
		long t = System.currentTimeMillis();
		char c = (char) (Math.random() * 26 + 'A');
		return "" + c + t / 20;
	}

	/**
	 * 购物车内容转化订单内容 
	 * @param order
	 * @param cartItems
	 * @return
	 */
	public static Set<OrderItem> cartItem2OrderItem(Order order, Set<CartItem> cartItems) {
		Set<OrderItem> orderItems = new HashSet<OrderItem>();
		for (CartItem ci : cartItems) {
			OrderItem oi = new OrderItem();
			oi.setGood(ci.getGood());
			oi.setAmount(ci.getQuantity());
			oi.setOrder(order);
			orderItems.add(oi);
		}
		order.setGoods(orderItems);
		return orderItems;
	}

	/**
	 * 每更新一次数据库，要从中重新加载一次进来，更新数据库
	 * @param httpRequest
	 * @param sid 
	 * @param shoppingCartService 
	 */
	public static void updateShoppingCartCache(HttpServletRequest httpRequest, ShoppingCartService shoppingCartService,Long sid) {
		User user = (User) httpRequest.getSession().getAttribute("user");
		ShoppingCart sc = shoppingCartService.load(sid);
		user.setShoppingCart(sc);
	}

	/**
	 * 初始化用户信息
	 */
	public static void initUser(User user) {
		//等级
		Grade grade = new Grade();
		grade.setExp(100);
		grade.setGrade(1);
		grade.setUser(user);
		//钱包
		Wallet wallet =new Wallet();
		wallet.setCredits(0);
		wallet.setUser(user);
		wallet.setOverage(0);
		//购物车
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setUser(user);
		
		user.setGrade(grade);
		user.setWallet(wallet );
		user.setShoppingCart(shoppingCart);
		
	}

}
