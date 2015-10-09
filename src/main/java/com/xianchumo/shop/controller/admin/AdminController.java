package com.xianchumo.shop.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;

public class AdminController {
	/**
	 * 登录
	 */
	@RequestMapping(value = "/login")
	public String login() {
		return "index";
	}

	/**
	 * 退出
	 */
	@RequestMapping(value = "/logout")
	public String logout() {
		return "index";
	}

	/**
	 * 修改密码
	 */
	@RequestMapping(value = "/modifyPassword")
	public String modifyPassword() {
		return "index";
	}

}
