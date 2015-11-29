package com.xianchumo.shop.dao;

import java.util.Date;
import java.util.List;

import com.vanroid.weixin.pojo.PageObj;
import com.xianchumo.shop.entity.Order;

public interface OrderDao extends BaseDao<Order>{
	/**
	 * 根据商家id查找对应的定单，每次查询20条
	 * @param merchantId
	 * @param page
	 * @return
	 */
	public List<Order> findByMerchant(Long merchantId, int page);
	/**
	 * 根据时间和订单状态查询订单
	 * @param merchantId
	 * @param page
	 * @param state
	 * @return
	 */
	public List<Order> findByDateAndState(Long merchantId, Date orderTime, int page, Integer state);
	/**
	 * 根据商家id查找对应的交易记录（已经完成），每次查询20条
	 * @param merchantId
	 * @param page
	 * @return
	 */
	public List<Order> findRecordByMerchant(Long merchantId, int page);
	/**
	 * 根据商家的id和订单的状态进行查询
	 * @param merchantId
	 * @param state
	 * @param page
	 * @return
	 */
	public List<Order> findByMerchantAndState(Long merchantId, int state, int page);
	
	public PageObj<Order> findOrder(int page);
	/**
	 * 查找某个时间段内的订单
	 * @param orderTime
	 * @param page
	 * @return
	 */
	public PageObj<Order> findByOrderTime(Date startTime, Date endTime, int page);
	
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
