package com.xianchumo.shop.test.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xianchumo.shop.entity.AddressBase;
import com.xianchumo.shop.entity.Merchant;
import com.xianchumo.shop.service.MerchantService;
import com.xianchumo.shop.util.Md5Utils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/resources/spring-hibernate.xml")
public class MerchantServiceTest {
	@Autowired
	private MerchantService merchantService;
	@Test
	public void testAdd() {
		
		Merchant entity = new Merchant();
		entity.setAccount("cgzgduf");
		entity.setPhone("13589687402");
		entity.setPassword(Md5Utils.md5("123456"));
		AddressBase address = new AddressBase();
		address.setAbid(2l);
		entity.setAddressBase(address );
		merchantService.add(entity );
	}

}
