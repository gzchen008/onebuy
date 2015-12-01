package com.xianchumo.shop.util;

import com.xianchumo.shop.entity.Order;
import com.xianchumo.shop.entity.OrderState;
import com.xianchumo.shop.exception.ShopException;
import com.xianchumo.shop.service.OrderService;

/**
 * 处理订单的工具类
 * @author yangtk
 *
 */
public class OrderUtil {
	/**
	 * 根据当前订单状态，返回其上一级状态
	 * @param nowState
	 * @return
	 */
	public static int preState(int nowState){
		switch(nowState){
			case OrderState.PAID 		 : return OrderState.GENERATE;
			case OrderState.SEND 		 : return OrderState.PAID;
			case OrderState.SUCCESS 	 : return OrderState.SEND;
			case OrderState.FAIL 		 : return OrderState.SEND;
			case OrderState.APPLY_REFUND : return OrderState.PAID;
			case OrderState.REFUND 		 : return OrderState.APPLY_REFUND;
			default						 : return OrderState.DEFAULT;
		}
	}
	/**
	 * 判断订单状态与当前订单状态的前一级状态
	 * @param orderState 订单状态
	 * @param nowState 当前订单状态
	 * @return
	 */
	public static boolean stateIsRight(int orderState, int nowState){
		return orderState == OrderUtil.preState(nowState);
	}
	public static Order getAndChangeOrder(OrderService orderService, 
			Long orderId, int orderState){
		if(orderId == null){
			throw new ShopException("订单ID不存在！");
		}
		Order order = orderService.get(orderId);
		if(order == null){
			throw new ShopException("订单不存在！");
		}
		if(!OrderUtil.stateIsRight(
				order.getOrderState(), orderState)){
			throw new ShopException("订单状态不正确！");
		}
		return order;
	}
}
