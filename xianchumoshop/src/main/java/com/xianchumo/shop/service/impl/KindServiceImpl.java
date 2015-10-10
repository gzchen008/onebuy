package com.xianchumo.shop.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xianchumo.shop.dao.BaseDao;
import com.xianchumo.shop.entity.Kind;
import com.xianchumo.shop.service.KindService;
/**
 * 
 * Copyright 2015 xianchumo.com
 * @Team xianchumo
 * @data：2015年9月19日
 * @author CGZ
 * @description
 */
@Service("kindService")
@Transactional
public class KindServiceImpl extends BaseServiceImpl<Kind>
	implements KindService{
	@Resource(name="kindDao")
	public void setDao(BaseDao<Kind> dao){
		super.setDao(dao);
	}
}