package com.xianchumo.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xianchumo.shop.dao.BaseDao;
import com.xianchumo.shop.entity.Address;
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

	@Override
	public Merchant findByAccount(String account) {
		String queryString = "FROM Merchant AS merchant WHERE merchant.account=?";
		List<Merchant> list = this.dao.find(queryString, account);
		if(list != null && list.size() != 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void createMerchant(String account, String password, Address address) {

		
	}
	
}
