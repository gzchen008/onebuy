package com.xianchumo.shop.test.service;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xianchumo.shop.entity.Good;
import com.xianchumo.shop.entity.OrderItem;
import com.xianchumo.shop.entity.ShoppingCart;
import com.xianchumo.shop.entity.User;
import com.xianchumo.shop.service.ShoppingCartService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/resources/spring-hibernate.xml")
public class ShoppingCartServiceTest {
	@Autowired
	private ShoppingCartService shoppingCartService;

	@Test
	public void testUpdate() {
		/*ShoppingCart shoppingCart = new ShoppingCart();
		User user = new User();
		user.setUid(1l);
		user.setShoppingCart(shoppingCart);
		shoppingCart.setUser(user);*/
		/*ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setSid(1l);*/
		ShoppingCart shoppingCart = shoppingCartService.get(2l);
		shoppingCartService.updateCart(shoppingCart, 1l, 120);
		shoppingCartService.updateCart(shoppingCart, 2l, 1);
	}

}
