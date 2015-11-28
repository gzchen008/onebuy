package com.xianchumo.shop.interceptor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.xianchumo.shop.conf.ShopConfig;
import com.xianchumo.shop.entity.ShoppingCart;
import com.xianchumo.shop.entity.User;
import com.xianchumo.shop.service.ShoppingCartService;
import com.xianchumo.shop.service.UserService;
import com.xianchumo.shop.util.ShopUtil;

/**
 * 
 * Copyright 2015 xianchumo.com
 * 
 * @Team xianchumo
 * @data：2015年11月28日 @author CGZ
 * @description 购物车拦截器
 */
public class CartInterceptor implements HandlerInterceptor {
	@Resource
	private ShoppingCartService shoppingCartService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		ShoppingCart shoppingCart = (ShoppingCart) request.getSession().getAttribute("shoppingCart");
		if (shoppingCart == null) {
			ShopUtil.getShoppingCart(request, shoppingCartService);
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
