package com.xianchumo.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xianchumo.shop.dao.BaseDao;
import com.xianchumo.shop.entity.Good;
import com.xianchumo.shop.entity.Kind;
import com.xianchumo.shop.service.GoodService;

/**
 * 
 * Copyright 2015 xianchumo.com
 * 
 * @Team xianchumo
 * @data：2015年9月19日 @author CGZ
 * @description
 */
@Service("goodService")
@Transactional
public class GoodServiceImpl extends BaseServiceImpl<Good>implements GoodService {
	@Resource(name = "goodDao")
	public void setDao(BaseDao<Good> dao) {
		super.setDao(dao);
	}

	@Override
	public List<Good> findByCategory(Long kid) {
		return dao.find("from Good good where good.kind = ?", new Kind(kid));
	}

	@Override
	public List<Good> searchByName(String keywords) {
		return dao.find("from Good good where good.name like ?", "%" + keywords + "%");
	}

	@Override
	public List<Good> findByRemark(String remark) {
		return dao.find("from Good good where good.remark = ?",remark);
	}
}
