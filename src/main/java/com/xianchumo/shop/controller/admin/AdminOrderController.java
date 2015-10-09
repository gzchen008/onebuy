package com.xianchumo.shop.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 订单管理 Copyright 2015 xianchumo.com
 * 
 * @Team xianchumo
 * @data：2015年9月20日 @author CGZ
 * @description
 */
public class AdminOrderController {
	/**
	 * 订单详情
	 */
	@RequestMapping(value = "/orderDetail")
	public String orderDetail() {
		return "index";
	}

	/**
	 * 列出所有订单
	 */
	@RequestMapping(value = "/listOrder")
	public String listOrder() {
		return "index";
	}

	/**
	 * 列出某用户的订单
	 */
	@RequestMapping(value = "/userOrder")
	public String userOrder() {
		return "index";
	}

	/**
	 * 查看订单操作记录
	 */
	@RequestMapping(value = "/operationRecord")
	public String operationRecord() {
		return "index";
	}

}
