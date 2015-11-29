package com.xianchumo.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xianchumo.shop.dao.BaseDao;
import com.xianchumo.shop.dao.RedPacketDao;
import com.xianchumo.shop.entity.RedPacket;
import com.xianchumo.shop.entity.User;
import com.xianchumo.shop.service.RedPacketService;

/**
 * 
 * Copyright 2015 xianchumo.com
 * 
 * @Team xianchumo
 * @data：2015年9月19日 @author CGZ
 * @description
 */
@Service("redPacketService")
@Transactional
public class RedPacketServiceImpl extends BaseServiceImpl<RedPacket>implements RedPacketService {
	@Resource(name = "redPacketDao")
	public void setDao(BaseDao<RedPacket> dao) {
		super.setDao(dao);
	}

	@Override
	public List<RedPacket> findByUser(User user) {
		return dao.find("from RedPacket rp where rp.user = ?",user);
	}

	@Override
	public int countByUser(User user) {
		return ((RedPacketDao)dao).countByUser(user);
	}
}
