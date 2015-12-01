package com.xianchumo.shop.dao;

import com.xianchumo.shop.entity.CartItem;
import com.xianchumo.shop.entity.ShoppingCart;

/**
 * 
 * Copyright 2015 xianchumo.com
 * 
 * @Team xianchumo
 * @data：2015年9月19日 @author CGZ
 * @description
 */
public interface ShoppingCartDao extends BaseDao<ShoppingCart> {

	void deleteCartItem(CartItem ci);
}
