package com.xianchumo.shop.service;

import com.xianchumo.shop.entity.Admin;

public interface AdminService extends BaseService<Admin>{
	public Admin findByAccount(String account);
	public Admin createAdmin(String account, String password);
}
