package com.xianchumo.shop.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.xianchumo.shop.dao.ShoppingCartDao;
import com.xianchumo.shop.entity.CartItem;
import com.xianchumo.shop.entity.ShoppingCart;
@Repository(value="shoppingCartDao")
public class ShoppingCartDaoImpl extends BaseDaoImpl<ShoppingCart> 
	implements ShoppingCartDao{

	@Override
	public void deleteCartItem(CartItem ci) {
		//Session session = getHibernateTemplate().getSessionFactory().openSession();
		//session.createQuery("delete from ");
		getHibernateTemplate().delete(ci);
	}


	
}
