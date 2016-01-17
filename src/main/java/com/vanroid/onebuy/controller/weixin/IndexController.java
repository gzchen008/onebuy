package com.vanroid.onebuy.controller.weixin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vanroid.onebuy.entity.User;

/**
 * 
 * Copyright 2015 xianchumo.com
 * 
 * @Team xianchumo
 * @data：2015年9月20日 @author CGZ
 * @description 首页控制器
 */
@Controller
public class IndexController {
	@RequestMapping("/")
	@ResponseBody
	public User index(){
		User user = new User();
		user.setId(232l);
		user.setPassword("23423423");
		user.setUsername("asdfgtrbbgre");
		return user;
	}

}