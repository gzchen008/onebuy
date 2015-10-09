package com.xianchumo.shop.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 用户管理
 * Copyright 2015 xianchumo.com
 * @Team xianchumo
 * @data：2015年9月20日
 * @author CGZ
 * @description
 */
public class AdminUserController {
	/**
	 * 用户列表
	 */
	@RequestMapping(value = "/listUser")
	public String listUser() {
		return "index";
	}

	/**
	 * 修改用户信息
	 */
	@RequestMapping(value = "/modifyUserInfo")
	public String modifyUserInfo() {
		return "index";
	}
	
	
}
