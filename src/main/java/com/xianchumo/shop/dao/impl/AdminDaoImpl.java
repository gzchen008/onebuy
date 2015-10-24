package com.xianchumo.shop.dao.impl;

import org.springframework.stereotype.Repository;

import com.xianchumo.shop.dao.AdminDao;
import com.xianchumo.shop.entity.Admin;

@Repository(value = "adminDao")
public class AdminDaoImpl extends BaseDaoImpl<Admin>
	implements AdminDao{

}
