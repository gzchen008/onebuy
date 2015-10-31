package com.xianchumo.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xianchumo.shop.dao.BaseDao;
import com.xianchumo.shop.dao.MerchantDao;
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
	private MerchantDao merchantDao;
	public static int PAGE_SIZE = 20;
	@Resource(name="merchantDao")
	public void setDao(BaseDao<Merchant> dao){
		super.setDao(dao);
		merchantDao = (MerchantDao)dao;
	}

	@Override
	public Merchant findByAccount(String account) {
		return merchantDao.findByAccount(account);
	}

	@Override
	public List<Merchant> findMerchant(int page) {
		return merchantDao.findMerchant(page);
	}
	
	@Override
	public List<Merchant> findByAddress(Long addressId, int page) {
		return merchantDao.findByAddress(addressId, page);
	}

	@Override
	public void createMerchant(String account, String password, Address address) {

		
	}

	@Override
	public Merchant findByAddress(Long addressId) {
		return merchantDao.findByaddress(addressId);
	}
	
	
	
}
