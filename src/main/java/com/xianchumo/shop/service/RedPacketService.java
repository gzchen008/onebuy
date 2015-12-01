package com.xianchumo.shop.service;

import java.util.List;

import com.xianchumo.shop.entity.RedPacket;
import com.xianchumo.shop.entity.User;
/**
 * 
 * Copyright 2015 xianchumo.com
 * @Team xianchumo
 * @data：2015年9月19日
 * @author CGZ
 * @description 红包服务
 */
public interface RedPacketService extends BaseService<RedPacket>{

	List<RedPacket> findByUser(User user);

	int countByUser(User user);

}
