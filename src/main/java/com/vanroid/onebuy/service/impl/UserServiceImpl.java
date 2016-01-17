package com.vanroid.onebuy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vanroid.onebuy.dao.BaseDao;
import com.vanroid.onebuy.entity.User;
import com.vanroid.onebuy.service.UserService;

/**
 * 
 * @company vanroid.com
 * @author cgz
 * @date 2016年1月17日
 * @version 1.0
 * @description TODO
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	@Override
	@Resource(name = "userDao")
	public void setDao(BaseDao<User> dao) {
		super.setDao(dao);
	}

}
