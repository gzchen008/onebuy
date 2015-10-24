package com.xianchumo.shop.controller.merchant;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xianchumo.shop.entity.Merchant;
import com.xianchumo.shop.entity.Order;
import com.xianchumo.shop.entity.OrderState;
import com.xianchumo.shop.service.OrderService;
/**
 * @Team xianchumo
 * @data:2015年9月25日 
 * @author yangtk
 * 
 */
@Controller
@Scope("request")
@RequestMapping(value = "/merchant/order")
@SessionAttributes("merchant")
public class MerchantOrderController {
	
	private OrderService orderService;
	@Autowired
	public void setOrderService(OrderService orderService){
		this.orderService = orderService;
	}
	/**
	 * 确认订单
	 */
	@RequestMapping(value = "/comfirmOrder")
	public String comfirmOrder(@RequestParam("order_id") String orderId, Model model) {
		if(orderId == null){
			return "/merchant/error";
		}
		Order order = orderService.get(Long.parseLong(orderId));
		if(order == null){
			return "/merchant/error";
		}
		if(order.getOrderState() != OrderState.PAID){
			return "/merchant/error";
		}
		order.setOrderState(OrderState.SNED);
		orderService.update(order);
		model.addAttribute("order", order);
		return "/merchant/singleOrder";
	}

	/**
	 * 取消订单
	 */
	@RequestMapping(value = "/cancleOrder")
	public String cancleOrder(@RequestParam("order_id") String orderId) {
		if(orderId == null){
			return "/merchant/error";
		}
		Order order = orderService.get(Long.parseLong(orderId));
		if(order == null){
			return "/merchant/error";
		}
		if(order.getOrderState() != OrderState.GENERATE){
			return "/merchant/error";
		}
		order.setOrderState(OrderState.FAIL);
		orderService.update(order);
		
		return "/merchant/cancelOrder";
	}

	/**
	 * 订单详情
	 */
	@RequestMapping(value = "/orderDetail")
	public String orderDetail(@RequestParam("order_id") String orderId, Model model) {
		if(orderId == null){
			return "/merchant/error";
		}
		Order order = orderService.get(Long.parseLong(orderId));
		if(order == null){
			return "/merchant/error";
		}
		if(order.getOrderState() != OrderState.PAID){
			return "/merchant/error";
		}
		order.setOrderState(OrderState.SNED);
		orderService.update(order);
		model.addAttribute("order", order);
		return "/merchant/singleOrder";
	}
	/**
	 * 列出订单
	 */
	@RequestMapping(value = "/listOrder")
	public String listOrder(Model model,HttpSession session) {
		Merchant merchant = (Merchant)session.getAttribute("merchant");
		model.addAttribute("orders", orderService.findByMerchant(merchant.getMid(), 0));
		return "/merchant/order";
	}

}
