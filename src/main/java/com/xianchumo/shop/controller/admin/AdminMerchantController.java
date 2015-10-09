package com.xianchumo.shop.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Merchant管理 Copyright 2015 xianchumo.com
 * 
 * @Team xianchumo
 * @data：2015年9月20日 @author CGZ
 * @description
 */
public class AdminMerchantController {
	/**
	 * 商家列表
	 */
	@RequestMapping(value = "/listMerchant")
	public String listMerchant() {
		return "index";
	}

	/**
	 * 商户详细信息
	 */
	@RequestMapping(value = "/merchantDetail")
	public String merchantDetail() {
		return "index";
	}

	/**
	 * 同意提现
	 */
	@RequestMapping(value = "/comfirmWithdraw")
	public String comfirmWithdraw() {
		return "index";
	}

}
