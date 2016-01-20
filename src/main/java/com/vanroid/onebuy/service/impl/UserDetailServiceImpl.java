package com.vanroid.onebuy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vanroid.onebuy.dao.BaseDao;
import com.vanroid.onebuy.entity.UserDetail;
import com.vanroid.onebuy.service.UserDetailService;

/**
*@author kaiscript
*@date 2016年1月18日 下午3:49:18
*/
@SuppressWarnings("unchecked")
@Service("userDetailService")
public class UserDetailServiceImpl extends BaseServiceImpl<UserDetail> implements UserDetailService {
	
	@Override
	@Resource(name = "userDetailDao")
	public void setDao(BaseDao<UserDetail> dao) {
		super.setDao(dao);
	}
	
}
