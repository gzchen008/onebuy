package com.xianchumo.shop.controller.merchant;

import org.springframework.web.bind.annotation.RequestMapping;

public class MerchantOrderController {

	/**
	 * 确认订单
	 */
	@RequestMapping(value = "/comfirmOrder")
	public String comfirmOrder() {
		return "index";
	}

	/**
	 * 取消订单
	 */
	@RequestMapping(value = "/cancleOrder")
	public String cancleOrder() {
		return "index";
	}

	/**
	 * 订单详情
	 */
	@RequestMapping(value = "/orderDetail")
	public String orderDetail() {
		return "index";
	}
	/**
	 * 列出订单
	 */
	@RequestMapping(value = "/listOrder")
	public String listOrder() {
		return "index";
	}

}
