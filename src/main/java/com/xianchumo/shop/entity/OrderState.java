package com.xianchumo.shop.entity;

public class OrderState {
	public final static int DEFAULT = 0;//默认值
	public final static int GENERATE = 1;// 订单生成
	public final static int PAID = 2;// 买家已付款
	public final static int SEND = 3;// 商家已发货
	public final static int SUCCESS = 4;// 买家已提货,交易成功
	public final static int CANCLE = 5;// 订单取消
	
	
	public final static int APPLY_REFUND = 6;// 申请退款
	public final static int REFUND = 7;// 已退款
	public final static int FAIL = 9;// 交易失败
}
