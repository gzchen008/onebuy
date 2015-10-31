package com.xianchumo.shop.service;

import java.util.Set;

import com.xianchumo.shop.entity.CartItem;
import com.xianchumo.shop.entity.ShoppingCart;
/**
 * 
 * Copyright 2015 xianchumo.com
 * @Team xianchumo
 * @data：2015年9月19日
 * @author CGZ
 * @description
 */
public interface ShoppingCartService extends BaseService<ShoppingCart>{

	/**
	 * 更新购物车方法
	 * @param shoppingCart
	 * @param goodId 商品id
	 * @param count 商品数量 
	 * @return
	 */
	Set<CartItem> updateCart(ShoppingCart shoppingCart, Long goodId, Integer count);

	Set<CartItem> removeItem(ShoppingCart shoppingCart, Long goodId);
	/**
	 * 清空购物车
	 * @param shoppingCart 
	 */
	void removeAllItem(ShoppingCart shoppingCart);

}
