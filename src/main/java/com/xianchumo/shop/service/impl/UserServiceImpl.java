
package com.xianchumo.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xianchumo.shop.dao.UserDao;
import com.xianchumo.shop.dto.RegisterDto;
import com.xianchumo.shop.entity.User;
import com.xianchumo.shop.service.UserService;

/**
 * 
 * Copyright 2015 xianchumo.com
 * 
 * @Team xianchumo
 * @data：2015年9月19日 @author CGZ
 * @description
 */
@Service("userService")
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	private final int PAGE_SIZE = 20;
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	@Resource(name = "userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
		super.setDao(userDao);
	}

	@Override
	public void register(RegisterDto dto) {

	}

	@Override
	public User login(User user) {
		return userDao.loadByOpenId(user.getOpenid());
	}

	@Override
	public User getByOpenId(String openId) {
		return userDao.loadByOpenId(openId);
	}

	@Override
	public List<User> findUser(int page) {
		return userDao.listUser(page, PAGE_SIZE);
	}

}