package com.vanroid.onebuy.service;


import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vanroid.onebuy.entity.Order;
import com.vanroid.onebuy.entity.UserDetail;

/**
*@author kaiscript
*@date 2016年1月18日 下午3:55:33
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class UserDetailServiceTest {
	
	@Autowired
	private UserDetailService userDetailService;
	
	/*@Test
	public void testOneToOneLazy(){
		UserDetail ud = userDetailService.get(1);
		System.out.println(ud.getClass());
		System.out.println(ud.getUser());
	}*/
	
	@Test
	public void testOneToManyLazy(){
		UserDetail ud = userDetailService.get(1);
		System.out.println(ud.getOrders().getClass()); //PersistentSet
		/*Set<Order> orders = ud.getOrders();
		for(Order o:orders){
			System.out.println(o.getTime());
		}*/
	}
	
	
	
	/*@Test
	public void testGetCache(){
		long id = 1;
		UserDetail ud1 = userDetailService.get(id);
		System.out.println(ud1);
		UserDetail ud2 = userDetailService.get(id);
		System.out.println(ud2);
	}*/
	
}
