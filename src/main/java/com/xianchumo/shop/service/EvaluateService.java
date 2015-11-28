package com.xianchumo.shop.service;

import java.util.List;

import com.xianchumo.shop.entity.Evaluate;
/**
 * 
 * Copyright 2015 xianchumo.com
 * @Team xianchumo
 * @data：2015年9月19日
 * @author CGZ
 * @description
 */
public interface EvaluateService extends BaseService<Evaluate>{
	public List<Evaluate> findByMerchant(Long merchantId, int page);
}
