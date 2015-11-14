package com.xianchumo.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xianchumo.shop.dao.AddressBaseDao;
import com.xianchumo.shop.dao.BaseDao;
import com.xianchumo.shop.entity.Address;
import com.xianchumo.shop.entity.AddressBase;
import com.xianchumo.shop.entity.User;
import com.xianchumo.shop.service.AddressBaseService;

/**
 * 
 * Copyright 2015 xianchumo.com
 * 
 * @Team xianchumo
 * @data：2015年9月19日 @author CGZ
 * @description
 */
@Service("addressBaseService")
@Transactional
public class AddressBaseServiceImpl extends BaseServiceImpl<AddressBase>implements AddressBaseService {
	private AddressBaseDao addressBaseDao;

	@Resource(name = "addressBaseDao")
	public void setDao(BaseDao<AddressBase> dao) {
		super.setDao(dao);
		addressBaseDao = (AddressBaseDao) dao;
	}

	@Override
	public List<AddressBase> findChildByName(String name) {
		return addressBaseDao.findChildByName(name);
	}

	@Override
	public List<AddressBase> findChild(long pid) {
		return addressBaseDao.findChild(pid);
	}

	@Override
	public List<Address> findByUser(User user) {
		return addressBaseDao.findByUser(user);
	}
}
