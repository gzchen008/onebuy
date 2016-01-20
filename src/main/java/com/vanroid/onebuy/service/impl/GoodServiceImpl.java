package com.vanroid.onebuy.service.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vanroid.onebuy.dao.BaseDao;
import com.vanroid.onebuy.entity.Good;
import com.vanroid.onebuy.service.GoodService;

/**
*@author kaiscript
*@date 2016年1月19日 下午10:48:53
*/
@Service("goodService")
public class GoodServiceImpl extends BaseServiceImpl<Good> implements GoodService {

	@Override
	@Resource(name = "goodDao")
	public void setDao(BaseDao<Good> dao) {
		// TODO Auto-generated method stub
		super.setDao(dao);
	}

	
}
