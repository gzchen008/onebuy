package com.xianchumo.shop.controller.weixin;

import javax.persistence.metamodel.SetAttribute;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xianchumo.shop.entity.Order;
import com.xianchumo.shop.service.EvaluateService;
import com.xianchumo.shop.service.OrderService;

/**
 * 
 * Copyright 2015 xianchumo.com
 * 
 * @Team xianchumo
 * @data：2015年9月20日 @author CGZ
 * @description 评论控制器
 */
@Controller
@RequestMapping("eval")
public class EvaluateController {
	@Autowired
	private EvaluateService evaluateService;
	@Autowired
	private OrderService orderService;

	/**
	 * 首页
	 */
	@RequestMapping(value = "/evaluate")
	public String evaluate(HttpServletRequest request,Long id) {
		Order order = orderService.get(id);
		request.setAttribute("order", order);
		return "weixin/evaluate";
	}

}