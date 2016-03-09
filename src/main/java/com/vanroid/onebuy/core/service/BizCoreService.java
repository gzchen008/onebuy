package com.vanroid.onebuy.core.service;

import java.util.List;
import java.util.Set;

import com.vanroid.onebuy.entity.Category;
import com.vanroid.onebuy.entity.Code;
import com.vanroid.onebuy.entity.Good;
import com.vanroid.onebuy.entity.Order;
import com.vanroid.onebuy.entity.Stage;
import com.vanroid.onebuy.entity.User;

public interface BizCoreService {

	/**
	 * 获得所有商品列表
	 */
	void getAllGoods();

	/**
	 * 获取商品分类列表
	 * 
	 * @return
	 */
	List<Category> getGoodCategoryList();

	/**
	 * 创建订单方法
	 * 
	 * @param stage
	 * @param quantity
	 * @param user
	 * @return
	 */
	Order makeOrder(Stage stage, Integer quantity, User user);
	
	/**
	 * 支付方法
	 * @param order
	 * @return
	 */
	Boolean pay(Order order);
	
	/**
	 * 支付成功，回调方法
	 */
	void payNotify(Long orderId);

	/**
	 * 获取商品当期的详细信息
	 * 若当期未开始，返回的Stage没有ID
	 * @param productId
	 * @return
	 */
	Stage getStageDetailByProduct(Long productId);

}
