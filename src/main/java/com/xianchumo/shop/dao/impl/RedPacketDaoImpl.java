package com.xianchumo.shop.dao.impl;

import org.springframework.stereotype.Repository;

import com.xianchumo.shop.dao.RedPacketDao;
import com.xianchumo.shop.entity.RedPacket;
import com.xianchumo.shop.entity.User;

@Repository(value = "redPacketDao")
public class RedPacketDaoImpl extends BaseDaoImpl<RedPacket> implements RedPacketDao {

	@Override
	public int countByUser(User user) {
		String hql = "select count(*) from RedPacket as redPacket where redPacket.user = ?";
		return ((Long) getHibernateTemplate().iterate(hql, user).next()).intValue();
	}

}
