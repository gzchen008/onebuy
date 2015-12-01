package com.xianchumo.shop.dao.impl;

import org.springframework.stereotype.Repository;

import com.xianchumo.shop.dao.ShoppingCartDao;
import com.xianchumo.shop.entity.CartItem;
import com.xianchumo.shop.entity.ShoppingCart;
@Repository(value="shoppingCartDao")
public class ShoppingCartDaoImpl extends BaseDaoImpl<ShoppingCart> 
	implements ShoppingCartDao{

	@Override
	public void deleteCartItem(CartItem ci) {
		getHibernateTemplate().delete(ci);
	}

	

	
}
