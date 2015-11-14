package com.xianchumo.shop.controller.merchant;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xianchumo.shop.entity.Merchant;
import com.xianchumo.shop.entity.Order;
import com.xianchumo.shop.entity.OrderState;
import com.xianchumo.shop.exception.ShopException;
import com.xianchumo.shop.service.OrderService;
import com.xianchumo.shop.util.OrderUtil;
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
	public String comfirmOrder(Long orderId, HttpServletRequest req) {
		Order order = OrderUtil.getAndChangeOrder(
				orderService, orderId, OrderState.SEND);
		order.setOrderState(OrderState.SEND);
		orderService.update(order);
		req.setAttribute("order", order);
		return "/merchant/singleOrder";
	}

	/**
	 * 取消订单
	 */
	@RequestMapping(value = "/cancleOrder")
	public String cancleOrder(Long orderId) {
		Order order = OrderUtil.getAndChangeOrder(
				orderService, orderId, OrderState.FAIL);
		order.setOrderState(OrderState.FAIL);
		orderService.update(order);
		return "/merchant/cancelOrder";
	}

	/**
	 * 订单详情
	 */
	@RequestMapping(value = "/orderDetail")
	public String orderDetail(Long orderId, HttpServletRequest req) {
		if(orderId == null){
			throw new ShopException("订单ID不存在！");
		}
		Order order = orderService.get(orderId);
		req.setAttribute("order", order);
		return "/merchant/singleOrder";
	}
	
	
	
	/**
	 * 列出订单
	 */
	@RequestMapping(value = "/listOrder")
	public String listOrder(HttpServletRequest req, int page) {
		Merchant merchant = (Merchant)req.getSession().getAttribute("merchant");
		req.setAttribute("orders", orderService.findByMerchant(merchant.getMid(), page));
		return "/merchant/orderRecord";
	}
	
	@RequestMapping(value = "/orderManage")
	public String orderManage(HttpServletRequest req, int page){
		Merchant merchant = (Merchant)req.getSession().getAttribute("merchant");
		req.setAttribute("orders", orderService.findByMerchant(merchant.getMid(), page));
		return "/merchant/order";
	}
		
	/**
	 * 列出订单
	 */
	@RequestMapping(value = "/someOrder")
	public String someOrder(HttpServletRequest req, int page, int state){
		Merchant merchant = (Merchant)req.getSession().getAttribute("merchant");
		req.setAttribute("orders", orderService.findByMerchantAndState(merchant.getMid(), state, page));
		return "/merchant/order";
	}
	
}
