package com.xianchumo.shop.test.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xianchumo.shop.entity.AddressBase;
import com.xianchumo.shop.service.AddressBaseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/resources/applicationContext.xml")
public class AddressBaseServiceTest {
	@Autowired
	private AddressBaseService addressBaseService;

	@Test
	public void testAdd() {

	}


	@Test
	public void testLoad() {
		AddressBase adb = addressBaseService.get(4);
		System.out.println(adb);
	
	}

	@Test
	public void testFindByName() {
		List<AddressBase> ls = addressBaseService.findChildByName("广州市");
		System.out.println(ls.get(0));
	}
	@Test
	public void testFindChild(){
		List<AddressBase> ls = addressBaseService.findChild(1);
		System.out.println(ls.get(0));
	}

}
