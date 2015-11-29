package com.xianchumo.shop.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xianchumo.shop.service.UserService;
/**
 * 用户管理
 * Copyright 2015 xianchumo.com
 * @Team xianchumo
 * @data：2015年9月20日
 * @author CGZ
 * @description
 */
@Controller
@RequestMapping("/admin/user")
public class AdminUserController {
	@Autowired
	private UserService userService;
	/**
	 * 用户列表
	 */
	@RequestMapping(value = "/listUser")
	public String listUser(HttpServletRequest req, int page) {
		req.setAttribute("users", userService.findUser(page));
		return "/admin/userManage";
	}

	/**
	 * 修改用户信息
	 */
	@RequestMapping(value = "/modifyUserInfo")
	public String modifyUserInfo() {
		return "index";
	}
	
	
}
