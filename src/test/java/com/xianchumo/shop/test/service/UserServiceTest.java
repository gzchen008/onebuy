package com.xianchumo.shop.test.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xianchumo.shop.entity.Grade;
import com.xianchumo.shop.entity.User;
import com.xianchumo.shop.entity.Wallet;
import com.xianchumo.shop.service.UserService;
import com.xianchumo.shop.util.ShopUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/resources/applicationContext.xml")
public class UserServiceTest {
	@Autowired
	private UserService userService;
	@Test
	public void testAdd() {
/*		User user = new User();
		user.setName("梁生");
		user.setOpenid("dfasdf41d65sf4sa");
		user.setPhone("12826245152");
		Wallet wallet = new Wallet();
		wallet.setUser(user);
		wallet.setCredits(434);
		wallet.setOverage(98);		
		user.setWallet(wallet );
		Grade grade = new Grade();
		grade.setUser(user);
		grade.setExp(1000);
		grade.setGrade(10);
		user.setGrade(grade );
		userService.add(user);*/
		User user = new User();
		user.setOpenid("123456789");
		user.setName("陈大侠");
		user.setPhone("18824233872");
		
		ShopUtil.initUser(user);
		userService.add(user);
	}
	@Test
	public void testLogin(){
		User user = new User();
		user.setOpenid("dfasdf41d65sf4sa");
		User u = userService.login(user);
		System.out.println(u);
	}

}
