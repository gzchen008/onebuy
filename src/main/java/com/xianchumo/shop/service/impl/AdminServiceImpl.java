package com.xianchumo.shop.service.impl;



import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xianchumo.shop.dao.AdminDao;
import com.xianchumo.shop.dao.BaseDao;
import com.xianchumo.shop.entity.Admin;
import com.xianchumo.shop.service.AdminService;
@Service("adminService")
@Transactional
public class AdminServiceImpl extends BaseServiceImpl<Admin>
	implements AdminService{
	private AdminDao adminDao;
	@Resource(name = "adminDao")
	public void setDao(BaseDao<Admin> dao){
		super.setDao(dao);
		adminDao = (AdminDao)dao;
	}

	@Override
	public Admin findByAccount(String account) {
		return adminDao.findByAccount(account);
	}

	@Override
	public Admin createAdmin(String account, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
