package com.xianchumo.shop.service;

import java.util.List;

import com.xianchumo.shop.entity.Good;
import com.xianchumo.shop.entity.Order;
/**
 * 
 * Copyright 2015 xianchumo.com
 * @Team xianchumo
 * @data：2015年10月31日
 * @author yangtk
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

	/**
	 * 通过备注查找商品
	 * @return
	 */
	List<Good> findByRemark(String remark);
	
	List<Good> findGood(int page);
}
