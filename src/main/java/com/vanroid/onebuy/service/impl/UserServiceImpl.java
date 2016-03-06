package com.vanroid.onebuy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vanroid.onebuy.dao.BaseDao;
import com.vanroid.onebuy.dao.UserDao;
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

	private UserDao userDao;

	@Override
	@Resource(name = "userDao")
	public void setDao(BaseDao<User> dao) {
		super.setDao(dao);
		this.userDao = (UserDao) dao;
	}

	@Override
	public User getByOpenId(String openId) {
		List<User> userList = userDao.find("FROM User user WHERE user.wxOpenid = ?", openId);
		return (userList == null || userList.size() == 0) ? null : userList.get(0);
	}

}
