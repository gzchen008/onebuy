package com.xianchumo.shop.util;

import com.xianchumo.shop.entity.OrderState;

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
			case OrderState.SNED 		 : return OrderState.PAID;
			case OrderState.SUCCESS 	 : return OrderState.SNED;
			case OrderState.FAIL 		 : return OrderState.SNED;
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
}
