package com.vanroid.onebuy.controller.wechat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @company vanroid.com
 * @author cgz
 * @date 2016年3月5日
 * @version 1.0
 * @description 订单 控制器
 */
@Controller
@RequestMapping("/order")
public class WcOrderController {

	@RequestMapping("/luck/show")
	public String newestPage(HttpServletRequest request, Model model) {
		return "wechat/order/luck_show";
	}

}