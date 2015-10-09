package com.xianchumo.shop.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xianchumo.shop.dao.BaseDao;
import com.xianchumo.shop.entity.Address;
import com.xianchumo.shop.service.AddressService;

/**
 * 
 * Copyright 2015 xianchumo.com
 * 
 * @Team xianchumo
 * @data：2015年9月19日 @author CGZ
 * @description
 */
@Service("addressService")
@Transactional
public class AddressServiceImpl extends BaseServiceImpl<Address>implements AddressService {
	@Resource(name = "addressDao")
	public void setDao(BaseDao<Address> dao) {
		super.setDao(dao);
	}
}
