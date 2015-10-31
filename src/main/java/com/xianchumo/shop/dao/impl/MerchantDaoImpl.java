package com.xianchumo.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xianchumo.shop.dao.MerchantDao;
import com.xianchumo.shop.entity.Address;
import com.xianchumo.shop.entity.Merchant;
@SuppressWarnings("unchecked")
@Repository(value="merchantDao")
public class MerchantDaoImpl extends BaseDaoImpl<Merchant> 
	implements MerchantDao{
	public static int PAGE_SIZE = 20;
	@Override
	public Merchant findByaddress(Long addressId) {
		List<Merchant> list = find("From Merchant merchant Where merchant.addressBase.abid=?",addressId);
		if(list != null && list.size() != 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public Merchant findByAccount(String account) {
		List<Merchant> list = find(
				"FROM Merchant AS merchant WHERE merchant.account=?", account);
		if(list != null && list.size() != 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void createMerchant(String account, String password, Address address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Merchant> findMerchant(int page) {
		return find("FROM Merchant",
				page*PAGE_SIZE, PAGE_SIZE);
	}

	@Override
	public List<Merchant> findByAddress(Long addressId, int page) {
		return find("From Merchant AS merchant WHERE address_id=?",
				(page-1)*PAGE_SIZE, PAGE_SIZE);
	}

	
	
}
