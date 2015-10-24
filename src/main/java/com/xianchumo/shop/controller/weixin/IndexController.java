package com.xianchumo.shop.controller.weixin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xianchumo.shop.entity.CartItem;
import com.xianchumo.shop.entity.Good;
import com.xianchumo.shop.entity.ShoppingCart;
import com.xianchumo.shop.exception.ShopParameterExceptioin;
import com.xianchumo.shop.service.GoodService;
import com.xianchumo.shop.service.KindService;
import com.xianchumo.shop.service.ShoppingCartService;
import com.xianchumo.shop.util.ShopUtil;

/**
 * 
 * Copyright 2015 xianchumo.com
 * 
 * @Team xianchumo
 * @data：2015年9月20日 @author CGZ
 * @description 首页控制器
 */
@Controller
public class IndexController {
	@Autowired
	private GoodService goodService;
	@Autowired
	private KindService kindService;
	@Autowired
	private ShoppingCartService shoppingCartService;

	/**
	 * 首页
	 */
	@RequestMapping(value = "/index")
	public String search(HttpServletRequest request) {
		// 加载推荐商品
		List<Good> recGoods = goodService.findByRemark("recommend");
		List<Good> tlGoods = goodService.findByRemark("timelimit");
		request.setAttribute("recGoods", recGoods);
		request.setAttribute("tlGoods", tlGoods);
		return "weixin/index";
	}

}