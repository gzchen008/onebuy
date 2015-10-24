package com.xianchumo.shop.test.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xianchumo.shop.dao.AddressDao;
import com.xianchumo.shop.entity.Address;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/resources/spring-hibernate.xml")
public class AddressDaoTest {
	@Autowired
	private AddressDao addressDao;
/*

	@Test
	public void testAdd() {
		Address ad = new Address("广东", "广州", "天河");
		addressDao.save(ad);
	}
	@Test
	public void testDelete(){
		Address ad = new Address("广东", "广州", "天河");
		ad.setAid(new Long(3));
		addressDao.delete(ad);
	}*/
	
	@Test
	public void testGet(){
		Address entity = addressDao.get(new Long(2));
		System.out.println(entity);
	}

}
