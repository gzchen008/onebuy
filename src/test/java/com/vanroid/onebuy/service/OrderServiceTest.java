package com.vanroid.onebuy.service;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vanroid.onebuy.entity.Code;
import com.vanroid.onebuy.entity.Order;

/**
*@author kaiscript
*@date 2016年1月18日 下午4:35:02
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
@Transactional
public class OrderServiceTest {
	
	@Autowired
	private OrderService orderService;
	
	@Test
	public void testManyToOneLazy(){
		Order order = orderService.get(1);
//		System.out.println(order.getClass());
//		System.out.println(order.getUserDetail().getClass());// UserDetail_$$_xxxx
//		System.out.println(order.getUserDetail().getId());
		for(Code c:order.getCodes()){
			System.out.println(c.getCode());
		}

	}
}
