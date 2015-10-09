package com.xianchumo.shop.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xianchumo.shop.dao.BaseDao;
import com.xianchumo.shop.entity.Merchant;
import com.xianchumo.shop.service.MerchantService;
/**
 * 
 * Copyright 2015 xianchumo.com
 * @Team xianchumo
 * @data：2015年9月19日
 * @author CGZ
 * @description
 */
@Service("merchantService")
@Transactional
public class MerchantServiceImpl extends BaseServiceImpl<Merchant>
	implements MerchantService{
	@Resource(name="merchantDao")
	public void setDao(BaseDao<Merchant> dao){
		super.setDao(dao);
	}
}
