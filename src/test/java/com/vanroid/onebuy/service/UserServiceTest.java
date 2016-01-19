package com.vanroid.onebuy.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vanroid.onebuy.entity.User;

/**
 * 
 * @company vanroid.com
 * @author cgz
 * @date 2016年1月17日
 * @version 1.0
 * @description TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class UserServiceTest {
	@Autowired
	private UserService userService;

	@Test
	public void testSave() {
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setUserDetail(null);
			user.setUsername("在左dcg" + i);
			user.setPassword("234rtgrefsadcdvfew");
			userService.add(user);
		}
	}
	@Test
	public void testload(){
		User user = userService.load(1);
		System.out.println(user.getPassword());
	}
	@Test
	public void testFind(){
		List<User> list = userService.findAll();
		for(User user : list){
			System.out.println(user.getUsername());
		}
		List<User> list2 = userService.findAll();
	}
}
