package com.xianchumo.shop.controller.weixin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xianchumo.shop.entity.Evaluate;
import com.xianchumo.shop.entity.Good;
import com.xianchumo.shop.entity.Merchant;
import com.xianchumo.shop.entity.Order;
import com.xianchumo.shop.entity.User;
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
	/**
	 * 保存评价
	 */
	@RequestMapping(value = "/saveEval")
	public String saveEval(Long[] gid,String comment[],Double[] fraction,Long oid,Long mid,Long uid){
		List<Evaluate> entities = new ArrayList<Evaluate>();
		Merchant merchant = new Merchant();
		User user = new User();
		user.setUid(uid);
		merchant.setMid(mid);
		for(int i = 0;i<gid.length;i++){
			Evaluate evaluate= new Evaluate();
			evaluate.setGood(new Good(gid[i]));
			evaluate.setComment(comment[i]);
			evaluate.setFraction(fraction[i]);
			evaluate.setMerchant(merchant);
			evaluate.setUser(user);
			entities.add(evaluate);
		}
		evaluateService.saveOrUpdateAll(entities);
		//更改状态
		Order order = orderService.load(oid);
		order.setEvaStatus(1);
		orderService.update(order);
		return "weixin/evaluate-success";
	}

}