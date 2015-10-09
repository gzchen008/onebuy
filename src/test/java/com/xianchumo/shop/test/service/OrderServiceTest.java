package com.xianchumo.shop.test.service;


import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xianchumo.shop.entity.Address;
import com.xianchumo.shop.entity.Good;
import com.xianchumo.shop.entity.OrderItem;
import com.xianchumo.shop.entity.Merchant;
import com.xianchumo.shop.entity.Order;
import com.xianchumo.shop.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/resources/spring-hibernate.xml")
public class OrderServiceTest {
	@Autowired
	private OrderService orderService;
	@Test
	public void testAdd() {
		Order order = new Order();
		Address address = new Address();
		address.setAid(new Long(2));
		order.setAddress(address);
		Merchant merchant = new Merchant();
		merchant.setMid(1l);
		order.setMerchant(merchant);
		order.setMoney(324);
		//订单内容
		Set<OrderItem> goods = new HashSet<OrderItem>();
		OrderItem item = new OrderItem();
		item.setGood(new Good());
		goods.add(item);
		order.setGoods(goods);
		orderService.add(order);
	}

}
