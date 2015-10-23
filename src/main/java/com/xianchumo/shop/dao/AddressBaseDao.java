package com.xianchumo.shop.dao;

import java.util.List;

import com.xianchumo.shop.entity.AddressBase;

public interface AddressBaseDao extends BaseDao<AddressBase>{

	List<AddressBase> findChildByName(String name);

	List<AddressBase> findChild(Long pid);


}
