package com.xianchumo.shop.service.impl;



import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xianchumo.shop.dao.BaseDao;
import com.xianchumo.shop.entity.Admin;
import com.xianchumo.shop.service.AdminService;
@Service("adminService")
@Transactional
public class AdminServiceImpl extends BaseServiceImpl<Admin>
	implements AdminService{
	@Resource(name = "adminDao")
	public void setDao(BaseDao<Admin> dao){
		super.setDao(dao);
	}
}
