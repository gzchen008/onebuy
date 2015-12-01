package com.xianchumo.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xianchumo.shop.dao.AdminDao;
import com.xianchumo.shop.entity.Admin;

@Repository(value = "adminDao")
public class AdminDaoImpl extends BaseDaoImpl<Admin>
	implements AdminDao{

	@Override
	public Admin findByAccount(String account) {
		@SuppressWarnings("unchecked")
		List<Admin> list = find("From Admin Where account=?", account);
		if(list != null && list.size() != 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public Admin createAdmin(String account, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
