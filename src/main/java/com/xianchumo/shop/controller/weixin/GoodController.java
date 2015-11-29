package com.xianchumo.shop.controller.weixin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xianchumo.shop.entity.CartItem;
import com.xianchumo.shop.entity.Good;
import com.xianchumo.shop.entity.ShoppingCart;
import com.xianchumo.shop.exception.ShopParameterExceptioin;
import com.xianchumo.shop.service.GoodService;
import com.xianchumo.shop.service.KindService;
import com.xianchumo.shop.service.ShoppingCartService;
import com.xianchumo.shop.util.JsonUtil;
import com.xianchumo.shop.util.ShopUtil;

/**
 * 
 * Copyright 2015 xianchumo.com
 * 
 * @Team xianchumo
 * @data：2015年9月20日 @author CGZ
 * @description 商品控制器
 */
@Controller
@RequestMapping(value = "/good")
public class GoodController {
	@Autowired
	private GoodService goodService;
	@Autowired
	private KindService kindService;
	@Autowired
	private ShoppingCartService shoppingCartService;

	/**
	 * 关键字搜索
	 */
	@RequestMapping(value = "/search")
	public String search(String keywords, HttpServletRequest request,HttpSession session) {
		//保存搜索记录
		Set<String> history = (Set<String>) session.getAttribute("history");
		if(history == null){
			history = new HashSet<String>();
			session.setAttribute("history", history);
		}
		history.add(keywords);
		List<Good> ls = goodService.searchByName(keywords);
		if (ls != null && ls.size() != 0) {
			request.setAttribute("goods", ls);
			return "weixin/search";
		} else {
			return "weixin/search-not-found";
		}
	}

	/**
	 * 按类别查询
	 */
	@RequestMapping(value = "/product")
	public String findByCategory(Long kid, HttpServletRequest request,HttpSession session) {
		if (kid == null) { // 没有输入分类
			kid = 1l;
		}
		List<Good> goods = goodService.findByCategory(kid);
		request.setAttribute("goods", goods);
		request.setAttribute("currentKid", kid);
		//从购物车中获取数量
		ShoppingCart cart = (ShoppingCart) session.getAttribute("shoppingCart");
		Set cartdata = new HashSet();
		for(CartItem ci : cart.getCartItems()){
			Map<String,Object> temp = new HashMap<String,Object>();
			temp.put("gid", ci.getGood().getGid());
			temp.put("count", ci.getQuantity());
			cartdata.add(temp);
		}
		request.setAttribute("cartdata", JsonUtil.toString(cartdata));
		return "weixin/product";
	}

	/**
	 * 特价商品
	 */
	@RequestMapping(value = "/bargain")
	public String bargain() {
		return "index";
	}

	/**
	 * 列出套餐
	 */
	@RequestMapping(value = "/packageGoods")
	public String packageGoods() {
		return "index";
	}

	/**
	 * 商品基本信息
	 */
	@RequestMapping(value = "/goodInfo")
	public String goodInfo(Long gid, HttpServletRequest request) {

		return "index";
	}

	/**
	 * 商品详情
	 */
	@RequestMapping(value = "/product-info")
	public String goodDetail(Long gid, HttpServletRequest request) {
		if (gid == null) {
			throw new ShopParameterExceptioin("商品参数错误！");
		}
		Good good = goodService.get(gid);
		// 在产品页面显示数量
		ShoppingCart shoppingCart = ShopUtil.getShoppingCart(request, shoppingCartService);
		CartItem ci = shoppingCart.getCartItem(gid);
		if (ci == null) {
			ci = new CartItem();
			ci.setQuantity(0);
		}
		request.setAttribute("good", good);
		request.setAttribute("cartItem", ci);
		request.setAttribute("total", shoppingCart.getTotal());
		return "weixin/product-info";
	}

	/**
	 * 商品评价
	 */
	@RequestMapping(value = "/goodEvaluate")
	public String goodEvaluate() {
		return "index";
	}
}
