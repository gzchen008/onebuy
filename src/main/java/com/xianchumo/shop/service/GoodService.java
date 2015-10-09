package com.xianchumo.shop.service;

import java.util.List;

import com.xianchumo.shop.entity.Good;
/**
 * 
 * Copyright 2015 xianchumo.com
 * @Team xianchumo
 * @data：2015年9月19日
 * @author CGZ
 * @description
 */
public interface GoodService extends BaseService<Good>{

	/**
	 * 根据分类找出所有的商品
	 * @param kid
	 * @return
	 */
	List<Good> findByCategory(Long kid);

	List<Good> searchByName(String keywords);

}
