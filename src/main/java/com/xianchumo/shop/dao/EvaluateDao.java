package com.xianchumo.shop.dao;

import java.util.List;

import com.xianchumo.shop.entity.Evaluate;
/**
 * 
 * Copyright 2015 xianchumo.com
 * @Team xianchumo
 * @data：2015年10月31日
 * @author yangyk
 * @description
 */
public interface EvaluateDao extends BaseDao<Evaluate>{
	/**
	 * 根据商家查询其用户的评价
	 * @param merchantId
	 * @param page
	 * @return
	 */
	public List<Evaluate> findBuMerchant(Long merchantId, int page);
}
