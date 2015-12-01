
package com.xianchumo.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xianchumo.shop.dao.GoodDao;
import com.xianchumo.shop.entity.Good;
/**
 * 
 * Copyright 2015 xianchumo.com
 * @Team xianchumo
 * @data：2015年9月19日
 * @author CGZ
 * @description
 */
@SuppressWarnings("unchecked")
@Repository(value="goodDao")
public class GoodDaoImpl extends BaseDaoImpl<Good> 
	implements GoodDao{
	@Override
	public List<Good> findGood(int page, int pageSize){
		return find("from Good", (page-1)*pageSize, pageSize);
	}

	
}
