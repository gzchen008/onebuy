package com.vanroid.onebuy.service;

import com.vanroid.onebuy.entity.Order;

/**
*@author kaiscript
*@date 2016年1月18日 下午4:12:58
*/
public interface OrderService extends BaseService<Order> {
	/**
	 * 为订单设置抽奖码，相当于发放抽奖码给用户
	 * @param orderId
	 */
	void pushCodeToOrder(int orderId);
}
