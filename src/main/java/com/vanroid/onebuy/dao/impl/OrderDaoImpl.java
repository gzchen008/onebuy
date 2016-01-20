package com.vanroid.onebuy.dao.impl;

import org.springframework.stereotype.Repository;

import com.vanroid.onebuy.dao.OrderDao;
import com.vanroid.onebuy.entity.Order;

/**
*@author kaiscript
*@date 2016年1月18日 下午4:12:06
*/
@Repository("orderDao")
public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao {

}
