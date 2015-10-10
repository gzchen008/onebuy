package com.xianchumo.shop.service;

import com.xianchumo.shop.dto.RegisterDto;
import com.xianchumo.shop.entity.User;
/**
 * 
 * Copyright 2015 xianchumo.com
 * @Team xianchumo
 * @data：2015年9月19日
 * @author CGZ
 * @description
 */
public interface UserService extends BaseService<User>{
	/**
	 * 用户注册
	 */
	void register(RegisterDto dto);
	/**
	 * 用户登录
	 */
	User login(User user);
}
