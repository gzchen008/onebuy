package com.xianchumo.shop.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xianchumo.shop.dao.ShoppingCartDao;
import com.xianchumo.shop.entity.CartItem;
import com.xianchumo.shop.entity.Good;
import com.xianchumo.shop.entity.ShoppingCart;
import com.xianchumo.shop.service.ShoppingCartService;

/**
 * 
 * Copyright 2015 xianchumo.com
 * 
 * @Team xianchumo
 * @data：2015年9月19日 @author CGZ
 * @description
 */
@Service("shoppingCartService")
@Transactional
public class ShoppingCartServiceImpl extends BaseServiceImpl<ShoppingCart>implements ShoppingCartService {

	private ShoppingCartDao shoppingCartDao;

	@Override
	public Set<CartItem> updateCart(ShoppingCart shoppingCart, Long goodId, Integer count) {
		Set<CartItem> cartItems = shoppingCart.getCartItems();
		CartItem c = new CartItem();
		c.setGood(new Good(goodId));
		boolean isNew = true;
		if (cartItems != null) {
			// 查找
			for (CartItem ci : cartItems) {
				if (ci.equals(c)) {
					// 修改数量
					ci.setQuantity(count);
					isNew = false;
					break;
				}
			}
			if (isNew) {
				// 加入
				c.setQuantity(count);
				shoppingCart.getCartItems().add(c);
			}
		} else {
			cartItems = new HashSet<CartItem>();
			c.setQuantity(count);
			cartItems.add(c);
			shoppingCart.setCartItems(cartItems);
		}
		c.setShoppingCart(shoppingCart);
		System.out.println("SID:" + shoppingCart.getSid());
		// 存入数据库
		dao.saveOrUpdate(shoppingCart);
		return cartItems;
	}

	public ShoppingCartDao getShoppingCartDao() {
		return shoppingCartDao;
	}

	@Resource(name = "shoppingCartDao")
	public void setShoppingCartDao(ShoppingCartDao shoppingCartDao) {
		this.shoppingCartDao = shoppingCartDao;
		setDao(shoppingCartDao);
	}

	@Override
	public Set<CartItem> removeItem(ShoppingCart shoppingCart, Long goodId) {
		for (CartItem c : shoppingCart.getCartItems()) {
			if (c.getGood().getGid() == goodId) {
				// 从数据库中删除
				shoppingCartDao.deleteCartItem(c);
				shoppingCart.getCartItems().remove(c);
				System.out.println("删除成功");
				break;
			}
		}
		return shoppingCart.getCartItems();
	}

}
