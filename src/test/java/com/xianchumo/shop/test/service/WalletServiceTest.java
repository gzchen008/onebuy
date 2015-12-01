package com.xianchumo.shop.test.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xianchumo.shop.service.WalletService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/resources/spring-hibernate.xml")
public class WalletServiceTest {
	@Autowired
	private WalletService walletService;
	@Test
	public void testAdd() {
		
	}

}
