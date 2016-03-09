package com.vanroid.onebuy.common;

/**
 * 
 * @company vanroid.com
 * @author cgz
 * @date 2016年3月6日
 * @version 1.0
 * @description 业务常量
 */
public class BizConstant {
	/**
	 * 订单状态:默认状态,订单生成,待支付
	 * 
	 */
	public static final int ORDER_STATUS_DEFAULT = 1;

	/**
	 * 订单状态:已支付
	 * 
	 */
	public static final int ORDER_STATUS_PAID = 2;

	/**
	 * 订单状态:已完成 期已揭晓
	 */
	public static final int ORDER_STATUS_FINISH = 3;

	/**
	 * 订单状态:订单取消
	 * 
	 */
	public static final int ORDER_STATUS_CANCEL = -1;

	/**
	 * 商品更新通知
	 */
	public static final int UPDATE_NOTIFY_GOOD = 1;

	/**
	 * 用户信息
	 */
	public static final String REQUEST_USER_INFO = "userInfo";
}
