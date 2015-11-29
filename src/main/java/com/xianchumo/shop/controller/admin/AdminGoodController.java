package com.xianchumo.shop.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xianchumo.shop.service.GoodService;

/**
 * 
 * @author yangtk
 * @Date 11.21
 */
@Controller
@Scope("request")
@RequestMapping("/admin/goodManage")
public class AdminGoodController {
	@Autowired
	private GoodService goodService;
	@RequestMapping("listGood")
	public String listGood(HttpServletRequest req, int page){
		req.setAttribute("goods", goodService.findGood(page));
		return "/admin/productManage";
	}
}
