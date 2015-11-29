package com.xianchumo.shop.controller.weixin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xianchumo.shop.entity.Good;
import com.xianchumo.shop.entity.RedPacket;
import com.xianchumo.shop.entity.User;
import com.xianchumo.shop.service.GoodService;
import com.xianchumo.shop.service.KindService;
import com.xianchumo.shop.service.RedPacketService;
import com.xianchumo.shop.service.ShoppingCartService;

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
	@Autowired
	private RedPacketService redPacketService;

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

	/**
	 *   查看我的红包
	 */
	@RequestMapping(value="redpacket") 
	public String redpacket(HttpServletRequest request,HttpSession session){
		User user = (User) session.getAttribute("user");
		List<RedPacket> packets = redPacketService.findByUser(user);
		session.setAttribute("packets", packets);
		return "weixin/red-packet";
	}
}