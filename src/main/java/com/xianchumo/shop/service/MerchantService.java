package com.xianchumo.shop.service;

import com.xianchumo.shop.entity.Address;
import com.xianchumo.shop.entity.Merchant;
/**
 * 
 * Copyright 2015 xianchumo.com
 * @Team xianchumo
 * @data：2015年9月19日
 * @author CGZ
 * @description
 */

public interface MerchantService extends BaseService<Merchant>{
	public Merchant findByAccount(String account);
	public void createMerchant(String account, String password, Address address);
}
