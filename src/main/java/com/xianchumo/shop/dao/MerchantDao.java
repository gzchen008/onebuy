package com.xianchumo.shop.dao;

import java.util.List;

import com.xianchumo.shop.entity.Address;
import com.xianchumo.shop.entity.Merchant;
/**
 * 
 * Copyright 2015 xianchumo.com
 * @Team xianchumo
 * @data：2015年10月31日
 * @author CGZ
 * @description
 */
public interface MerchantDao extends BaseDao<Merchant>{
	public Merchant findByaddress(Long addressId);
	
	public Merchant findByAccount(String account);
	
	public void createMerchant(String account, String password, Address address);
	
	public List<Merchant> findMerchant(int page);
	
	public List<Merchant> findByAddress(Long addressId, int page);

}
