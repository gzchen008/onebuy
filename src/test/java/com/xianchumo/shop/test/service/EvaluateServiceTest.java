package com.xianchumo.shop.test.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xianchumo.shop.entity.Evaluate;
import com.xianchumo.shop.entity.Good;
import com.xianchumo.shop.entity.Merchant;
import com.xianchumo.shop.entity.User;
import com.xianchumo.shop.service.EvaluateService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/resources/spring-hibernate.xml")
public class EvaluateServiceTest {
	@Autowired
	private EvaluateService evaluateService;
	@Test
	public void testAdd() {
		
		Evaluate entity  = new Evaluate();
		User user = new User();
		user.setUid(new Long(1));
		
		entity.setUser(user );
		Good good = new Good();
		good.setGid(1l);
		entity.setGood(good);
		Merchant merchant = new Merchant();
		merchant.setMid(1l);
		entity.setMerchant(merchant ); 	
		entity.setFraction(100);
		entity.setComment("很好");
		
		evaluateService.add(entity);
	}

}
