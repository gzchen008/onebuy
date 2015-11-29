package com.xianchumo.shop.service;

import com.xianchumo.shop.entity.Evaluate;
import com.xianchumo.shop.entity.PageObj;
/**
 * 
 * Copyright 2015 xianchumo.com
 * @Team xianchumo
 * @data：2015年9月19日
 * @author CGZ
 * @description
 */
public interface EvaluateService extends BaseService<Evaluate>{
	/**
	 * 获得某商家评价
	 * @param merchantId
	 * @param page
	 * @return
	 */
	public PageObj<Evaluate> findByMerchant(Long merchantId, int page);
}
