package com.xianchumo.shop.dao;

import java.util.List;

import com.xianchumo.shop.entity.Address;
import com.xianchumo.shop.entity.AddressBase;
import com.xianchumo.shop.entity.User;

public interface AddressBaseDao extends BaseDao<AddressBase>{

	List<AddressBase> findChildByName(String name);

	List<AddressBase> findChild(Long pid);

	List<Address> findByUser(User user);


}
