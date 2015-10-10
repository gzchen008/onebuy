package com.xianchumo.shop.controller.weixin;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xianchumo.shop.entity.CartItem;
import com.xianchumo.shop.entity.ShoppingCart;
import com.xianchumo.shop.entity.User;
import com.xianchumo.shop.exception.ShopParameterExceptioin;
import com.xianchumo.shop.service.ShoppingCartService;
import com.xianchumo.shop.util.JsonUtil;
import com.xianchumo.shop.util.ShopUtil;

/**
 * 
 * Copyright 2015 xianchumo.com
 * 
 * @Team xianchumo
 * @data：2015年9月20日 @author CGZ
 * @description 购物车
 */
@RequestMapping(value = "/cart")
@Controller
public class ShoppingCartController {
	@Autowired
	private ShoppingCartService shoppingCartService;

	/**
	 * 更改购物车商品数量
	 * 
	 * @param goodId
	 *            商品号
	 * @param count
	 *            数量
	 */
	@RequestMapping(value = "/updateCart")
	public void updateCart(Long goodId, Integer count, HttpServletRequest httpRequest, HttpServletResponse response) {
		if (goodId == null)
			throw new ShopParameterExceptioin("商品号不能为空");
		// 添加商品，默认为1
		if (count == null) {
			count = 1;
		}
		// 获取用户购物车
		ShoppingCart shoppingCart = ShopUtil.getShoppingCart(httpRequest,shoppingCartService);
		// 更新购物车
		Set<CartItem> cartItems = shoppingCartService.updateCart(shoppingCart, goodId, count);
		// 输出该项数量、价格合计
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", shoppingCart.getTotal());
		map.put("quantity", count);
		JsonUtil.outPut(response, map);
	}

	/**
	 * 获取当前购物车数据
	 */
	@RequestMapping(value = "/cart")
	public String shoppingCart(HttpServletRequest httpRequest, HttpServletResponse response) {
		// 获取用户购物车
		ShoppingCart shoppingCart = ShopUtil.getShoppingCart(httpRequest,shoppingCartService);
		httpRequest.setAttribute("shoppingCart", shoppingCart);
		return "weixin/cart";
	}

	/**
	 * 删除购物车的某项
	 */
	@RequestMapping(value = "/remove")
	public void removeItem(Long goodId, HttpServletRequest httpRequest, HttpServletResponse response) {
		// 获取用户购物车
		ShoppingCart shoppingCart = ShopUtil.getShoppingCart(httpRequest,shoppingCartService);
		// 更新购物车
		shoppingCartService.removeItem(shoppingCart, goodId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", shoppingCart.getTotal());
		map.put("status", 1);
		JsonUtil.outPut(response, map);

	}
}
