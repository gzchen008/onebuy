package com.vanroid.onebuy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vanroid.onebuy.dao.BaseDao;
import com.vanroid.onebuy.entity.Category;
import com.vanroid.onebuy.entity.LuckShow;
import com.vanroid.onebuy.service.CategoryService;

/**
 * 
 * @company vanroid.com
 * @author cgz
 * @date 2016年3月5日
 * @version 1.0
 * @description TODO
 */
@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

	@Override
	@Resource(name = "categoryDao")
	public void setDao(BaseDao<Category> dao) {
		super.setDao(dao);
	}

}
