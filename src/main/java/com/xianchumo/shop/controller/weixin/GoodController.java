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
	public String search(String keywords,HttpServletRequest request ) {
		List<Good> ls = goodService.searchByName(keywords);
		request.setAttribute("goods", ls);
		return "weixin/search";
	}

	/**
	 * 按类别查询
	 */
	@RequestMapping(value = "/product")
	public String findByCategory(Long kid, HttpServletRequest request) {
		if (kid == null) { // 没有输入分类
			kid = 1l;
		}
		List<Good> goods = goodService.findByCategory(kid);
		request.setAttribute("goods", goods);
		request.setAttribute("currentKid", kid);
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
		//在产品页面显示数量
		ShoppingCart shoppingCart = ShopUtil.getShoppingCart(request, shoppingCartService);
		CartItem ci = shoppingCart.getCartItem(gid);
		if(ci == null){
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
