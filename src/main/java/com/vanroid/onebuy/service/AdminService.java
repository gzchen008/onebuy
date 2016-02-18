package com.vanroid.onebuy.service;

import com.vanroid.onebuy.entity.Admin;

/**
*@author kaiscript
*@date 2016年2月18日 下午4:21:48
*/
public interface AdminService extends BaseService<Admin>{
	
	Admin getAdminByName(String name);
}
