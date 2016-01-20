package com.vanroid.onebuy.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vanroid.onebuy.dao.BaseDao;
import com.vanroid.onebuy.entity.Order;
import com.vanroid.onebuy.service.OrderService;

/**
*@author kaiscript
*@date 2016年1月18日 下午4:13:52
*/
@Service("orderService")
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {

	@Override
	@Resource(name = "orderDao")
	public void setDao(BaseDao<Order> dao) {
		super.setDao(dao);
	}

}
