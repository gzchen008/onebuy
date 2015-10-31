package com.xianchumo.shop.dao;

import com.xianchumo.shop.entity.Admin;

public interface AdminDao extends BaseDao<Admin>{
	public Admin findByAccount(String account);
	
	public Admin createAdmin(String account, String password);
}
