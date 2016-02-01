package com.vanroid.onebuy.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vanroid.onebuy.entity.ShoppingCart;
import com.vanroid.onebuy.entity.Stage;
import com.vanroid.onebuy.entity.User;

/**
*@author kaiscript
*@date 2016年2月1日 下午6:00:18
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class ShoppingCartServiceTest {
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	@Autowired
	private StageService stageService;
	@Autowired
	private UserService userService;
	
	@Test
	public void shoppingTest(){
		Stage stage = stageService.get(1);
		User user = userService.get(1);
		System.out.println(stage.getNum());
		System.out.println(user.getUsername());
		ShoppingCart sc = new ShoppingCart();
		sc.setQuality(2);
		sc.setStage(stage);
		sc.setOwnedUser(userService.get(1));
		shoppingCartService.add(sc);
		System.out.println(sc.getQuality());
	}
}
