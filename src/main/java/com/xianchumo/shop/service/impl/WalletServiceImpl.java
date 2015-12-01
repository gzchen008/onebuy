package com.xianchumo.shop.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xianchumo.shop.dao.BaseDao;
import com.xianchumo.shop.entity.Kind;
import com.xianchumo.shop.entity.Wallet;
import com.xianchumo.shop.service.WalletService;
/**
 * 
 * Copyright 2015 xianchumo.com
 * @Team xianchumo
 * @data：2015年9月19日
 * @author CGZ
 * @description
 */
@Service("walletService")
@Transactional
public class WalletServiceImpl extends BaseServiceImpl<Wallet>
	implements WalletService{
	@Resource(name="walletDao")
	public void setDao(BaseDao<Wallet> dao){
		super.setDao(dao);
	}
}
