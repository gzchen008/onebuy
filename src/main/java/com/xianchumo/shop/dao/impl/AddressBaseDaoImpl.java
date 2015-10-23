package com.xianchumo.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xianchumo.shop.dao.AddressBaseDao;
import com.xianchumo.shop.entity.AddressBase;
@Repository(value="addressBaseDao")
public class AddressBaseDaoImpl extends BaseDaoImpl<AddressBase> 
	implements AddressBaseDao{

	@Override
	public List<AddressBase> findChildByName(String name) {
		
		return find("from AddressBase ab where ab.parent.name = ?",name);
	}

	@Override
	public List<AddressBase> findChild(Long pid) {
		return find("from AddressBase ab where ab.parent.abid = ?",pid);
	}


	
}
