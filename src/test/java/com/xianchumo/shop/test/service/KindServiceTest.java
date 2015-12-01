package com.xianchumo.shop.test.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xianchumo.shop.entity.Kind;
import com.xianchumo.shop.entity.User;
import com.xianchumo.shop.service.KindService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/resources/spring-hibernate.xml")
public class KindServiceTest {
	@Autowired
	private KindService kindService;
	@Test
	public void testAdd() {
		
		Kind kind = new Kind();
		kind.setKindName("水果");
		kindService.add(kind );
	}

}
