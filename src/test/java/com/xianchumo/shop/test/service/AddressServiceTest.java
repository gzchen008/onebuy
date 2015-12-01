package com.xianchumo.shop.test.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xianchumo.shop.entity.Address;
import com.xianchumo.shop.service.AddressService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/resources/spring-hibernate.xml")
public class AddressServiceTest {
	@Autowired
	private AddressService addressService;
	@Test
	public void testAdd() {
		/*Address ad = new Address("广东", "广州", "天河");
		ad.setLiveArea("华农");
		addressService.add(ad);*/
	}

}
