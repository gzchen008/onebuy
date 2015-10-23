package com.xianchumo.shop.service;

import java.util.List;

import com.xianchumo.shop.entity.AddressBase;

public interface AddressBaseService extends BaseService<AddressBase>{
	/**
	 * 根据地址名找出直接下级
	 * @param string
	 * @return
	 */
	List<AddressBase> findChildByName(String name);

	/**
	 * 根据Id查找直接下级
	 * @param pid
	 * @return
	 */
	List<AddressBase> findChild(long pid);

}
