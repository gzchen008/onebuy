package com.xianchumo.shop.controller.merchant;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * Copyright 2015 xianchumo.com
 * 
 * @Team xianchumo
 * @data：2015年9月20日 @author CGZ
 * @description
 */
public class MerchantController {

	/**
	 * 登录
	 */
	@RequestMapping(value = "/login")
	public String login() {
		return "index";
	}

	/**
	 * 显示个人信息
	 */
	@RequestMapping(value = "/userInfo")
	public String userInfo() {
		return "index";
	}

	/**
	 * 修改个人信息
	 */
	@RequestMapping(value = "/modifyUserInfo")
	public String modifyUserInfo() {
		return "index";
	}

	/**
	 * 帐户信息
	 */
	@RequestMapping(value = "/accountInfo")
	public String accountInfo() {
		return "index";
	}

	/**
	 * 申请提现
	 */
	@RequestMapping(value = "/applyWithdraw")
	public String applyWithdraw() {
		return "index";
	}

}
