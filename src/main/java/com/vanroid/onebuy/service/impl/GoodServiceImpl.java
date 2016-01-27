package com.vanroid.onebuy.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vanroid.onebuy.dao.BaseDao;
import com.vanroid.onebuy.dao.GoodDao;
import com.vanroid.onebuy.entity.Good;
import com.vanroid.onebuy.service.GoodService;

/**
*@author kaiscript
*@date 2016年1月19日 下午10:48:53
*/
@Service("goodService")
public class GoodServiceImpl extends BaseServiceImpl<Good> implements GoodService {
	
	private GoodDao goodDao;
	
	@Override
	@Resource(name = "goodDao")
	public void setDao(BaseDao<Good> dao) {
		super.setDao(dao);
		this.goodDao = (GoodDao) dao;
	}

	@Override
	public Good getGoodByNameAndDescription(String name, String description) {
		List<Good> goodList = goodDao.find("from Good g where g.name = ? and g.description = ?", name,description);
		Set<Good> goods = new HashSet<Good>(goodList);
		Good good = new Good();
		for(Good g:goods){
			good = g;
		}
		return good;
	}
	
}
