package com.xianchumo.shop.test.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xianchumo.shop.entity.Merchant;
import com.xianchumo.shop.service.AddressBaseService;
import com.xianchumo.shop.service.MerchantService;
import com.xianchumo.shop.util.Md5Utils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/resources/applicationContext.xml")
public class AddMerchantTest {
	@Autowired
	private MerchantService merchantService;
	@Autowired
	private AddressBaseService addressBaseService;
	@Test
	public void add(){
		Merchant merchant = new Merchant();
		merchant.setAccount("yangtk");
		merchant.setPassword(Md5Utils.md5("123456"));
		merchant.setOverage(0);
		merchant.setTelephone("2798455");
		merchant.setPhone("18814127781");
		merchant.setAddressBase(addressBaseService.get(7L));
		merchantService.add(merchant);
	}
}
