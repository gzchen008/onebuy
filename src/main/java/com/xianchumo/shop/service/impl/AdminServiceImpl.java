package com.xianchumo.shop.service.impl;



import java.util.List;

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

	@Override
	public Admin findByAccount(String account) {
		String queryString = "FROM Admin WHERE account=?";
		List<Admin> list = this.dao.find(queryString, account);
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
