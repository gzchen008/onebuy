package com.vanroid.onebuy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vanroid.onebuy.dao.AdminDao;
import com.vanroid.onebuy.dao.BaseDao;
import com.vanroid.onebuy.dao.CodeDao;
import com.vanroid.onebuy.entity.Admin;
import com.vanroid.onebuy.entity.Code;
import com.vanroid.onebuy.service.AdminService;

/**
*@author kaiscript
*@date 2016年2月18日 下午4:23:17
*/
@Service("adminService")
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService {
	
	private AdminDao adminDao;
	
	@Override
	@Resource(name = "adminDao")
	public void setDao(BaseDao<Admin> dao) {
		super.setDao(dao);
		this.adminDao = (AdminDao) dao;
	}
	
	@Override
	public Admin getAdminByName(String name) {
		String queryString = "FROM Admin a WHERE a.name = ?";
		List<Admin> admins = adminDao.find(queryString, name);
		if(admins!=null)
			return admins.get(0);
		else 
			return null;
	}
	
}
