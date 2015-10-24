package com.xianchumo.shop.controller.admin;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xianchumo.shop.service.OrderService;

/**
 * 订单管理 Copyright 2015 xianchumo.com
 * 
 * @Team xianchumo
 * @data：2015年10月24日 @author yangtk
 * @description
 */
@Controller
@Scope("request")
@RequestMapping("/admin/order")
public class AdminOrderController {
	@Autowired
	private OrderService orderService;
	/**
	 * 订单详情
	 */
	@RequestMapping(value = "/orderDetail")
	public String orderDetail(Long orderId, HttpServletRequest req) {
		req.setAttribute("order", orderService.get(orderId));
		return "/views/admin/order/showOrder";
	}

	/**
	 * 列出所有订单
	 */
	@RequestMapping(value = "/listOrder")
	public String listOrder(int page, HttpServletRequest req) {
		req.setAttribute("orders", orderService.findOrder(page));
		return "/views/admin/order/listOrder";
	}
	/**
	 * 列出某时间段的订单
	 */
	@RequestMapping(value = "/listOrderByTime")
	public String listOrderByTime(Date startTime, Date endTime, 
			int page, HttpServletRequest req) {
		req.setAttribute("orders", orderService
				.findByOrderTime(startTime, endTime, page));
		return "/views/admin/order/listOrder";
	}
	/**
	 * 列出某用户的订单
	 */
	@RequestMapping(value = "/userOrder")
	public String userOrder(String phone, int page, HttpServletRequest req) {
		req.setAttribute("orders", orderService.findByUser(phone, page));
		return "/views/admin/order/listOrder";
	}
	/**
	 * 列出某用户的某个时间段内订单
	 */
	@RequestMapping(value = "/userOrderByTime")
	public String userOrderByTime(Date startTime, Date endTime,
			String phone, int page, HttpServletRequest req) {
		req.setAttribute("orders", orderService
				.findByUserAndTime(phone, startTime, endTime, page));
		return "/views/admin/order/listOrder";
	}
	/**
	 * 查看订单操作记录
	 */
	@RequestMapping(value = "/operationRecord")
	public String operationRecord() {
		return "index";
	}

}
