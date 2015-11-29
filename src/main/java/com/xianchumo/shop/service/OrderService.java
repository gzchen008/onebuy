package com.xianchumo.shop.service;

import java.util.Date;
import java.util.List;

import com.xianchumo.shop.entity.Order;
import com.xianchumo.shop.entity.PageObj;
import com.xianchumo.shop.entity.ShoppingCart;
/**
 * 
 * Copyright 2015 xianchumo.com
 * @Team xianchumo
 * @data：2015年10月31日
 * @author yangtk
 * @description
 */
public interface OrderService extends BaseService<Order>{
	/**
	 * 根据商家id查找对应的定单，每次查询20条
	 * @param merchantId
	 * @param page
	 * @param isRecord 是否查看完成后的订单
	 * @return
	 */
	public PageObj<Order> findByMerchant(Long merchantId, int page, boolean isRecord);
	/**
	 * 根据商家的id和订单的状态进行查询
	 * @param merchantId
	 * @param state
	 * @param page
	 * @return
	 */
	public PageObj<Order> findByMerchantAndState(Long merchantId, int state, int page);
	/**
	 * 创新订单
	 * @param cartItems
	 */
	public Order createOrder(ShoppingCart shoppingCart);
	
	/**
	 * 查询订单
	 * @param page
	 * @return
	 */
	public PageObj<Order> findOrder(int page);
	
	/**
	 * 查找某个时间段内的订单(商家)
	 * @param merchantId
	 * @param startTime
	 * @param endTime
	 * @param page
	 * @return
	 */
	public PageObj<Order> findByOrderTime(Long merchantId, String startTime, String endTime, int page);
	/**
	 * 查找某个时间段内的订单
	 * @param startTime
	 * @param endTime
	 * @param page
	 * @return
	 */
	public PageObj<Order> findByOrderTime( Date startTime, Date endTime, int page);
	
	/**
	 * 查询某个用户的订单
	 * @param phone
	 * @param page
	 * @return
	 */
	public PageObj<Order> findByUser(String phone, int page);
	
	/**
	 * 查询某个用户某个时间段内的订单
	 * @param phone
	 * @param startTime
	 * @param endTime
	 * @param page
	 * @return
	 */
	public PageObj<Order> findByUserAndTime(String phone, Date startTime, Date endTime, int page);
	
}
