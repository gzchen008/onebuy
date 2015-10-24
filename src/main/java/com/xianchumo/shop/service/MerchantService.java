package com.xianchumo.shop.service;

import java.util.List;

import com.xianchumo.shop.entity.Address;
import com.xianchumo.shop.entity.Merchant;
/**
 * 
 * Copyright 2015 xianchumo.com
 * @Team xianchumo
 * @data：2015年9月19日
 * @author yangtk
 * @description
 */

public interface MerchantService extends BaseService<Merchant>{
	public Merchant findByAccount(String account);
	
	public void createMerchant(String account, String password, Address address);
	
	public List<Merchant> findMerchant(int page);
	
	public List<Merchant> findByAddress(Long addressId, int page);
}
