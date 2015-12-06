package com.xianchumo.shop.dao;

import com.xianchumo.shop.entity.Evaluate;
import com.xianchumo.shop.entity.PageObj;
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
	public PageObj<Evaluate> findByMerchant(Long merchantId, int page);

	public PageObj<Evaluate> fidByGood(Long gid, int size, int page);
}
