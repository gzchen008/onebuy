package com.xianchumo.shop.dao;

import com.xianchumo.shop.entity.RedPacket;
import com.xianchumo.shop.entity.User;
/**
 * 
 * Copyright 2015 xianchumo.com
 * @Team xianchumo
 * @data：2015年9月19日
 * @author CGZ
 * @description
 */
public interface RedPacketDao extends BaseDao<RedPacket>{

	int countByUser(User user);

}
