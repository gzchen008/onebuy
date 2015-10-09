package com.xianchumo.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xianchumo.shop.dao.UserDao;
import com.xianchumo.shop.entity.User;
@Repository(value="userDao")
public class UserDaoImpl extends BaseDaoImpl<User> 
	implements UserDao{

	@Override
	public User loadByOpenId(String openId) {
		String hql = "from User where openId = ?";
		List<User> ls = find(hql,openId);
		return ls == null? null:ls.get(0);
	}


	
}
