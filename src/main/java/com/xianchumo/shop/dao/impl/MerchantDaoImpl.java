package com.xianchumo.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xianchumo.shop.dao.MerchantDao;
import com.xianchumo.shop.entity.Merchant;
@SuppressWarnings("unchecked")
@Repository(value="merchantDao")
public class MerchantDaoImpl extends BaseDaoImpl<Merchant> 
	implements MerchantDao{

	@Override
	public Merchant findByaddress(Long addressId) {
		List<Merchant> list = find("From Merchant merchant Where merchant.addressBase.abid=?",addressId);
		if(list != null && list.size() != 0){
			return list.get(0);
		}
		return null;
	}

	
	
}
