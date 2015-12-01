package com.xianchumo.shop.dao;

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
public interface GoodDao extends BaseDao<Good>{

	List<Good> findGood(int page, int pageSize);
}
