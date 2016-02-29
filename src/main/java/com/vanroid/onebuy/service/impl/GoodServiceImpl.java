package com.vanroid.onebuy.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vanroid.onebuy.common.Pager;
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
		List<Good> goodList = goodDao.find("from Good g where g.name = ? and g.description = ?", new String[]{name,description});
		Set<Good> goods = new HashSet<Good>(goodList);
		Good good = new Good();
		for(Good g:goods){
			good = g;
		}
		return good;
	}

	@Override
	public Good findByExampleGood(Good good) {
		List<Good> goods = goodDao.findByExampleEntity(good);
		return goods.get(0);
	}

	
	@Override
	public List<Good> findGoodFuzzy(String goodName) {
		String queryString = "from Good g where g.name like :name";
		String[] names = {"name"};
		Object[] goods = new Object[1];
		goods[0] = "%"+goodName+"%";
		List<Good> goodList = goodDao.find(queryString, names, goods);
		return goodList;
	}

	
	@Override
	public Pager findGoodFuzzyPager(String goodName,Pager pager) {
		List<Good> goods = this.findGoodFuzzy(goodName);
		pager.setTotalCount(goods.size());
		pager.init();
		pager.setDatas(goods);
		return pager;
	}
	
}
