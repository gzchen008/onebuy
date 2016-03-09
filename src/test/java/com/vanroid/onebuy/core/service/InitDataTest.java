package com.vanroid.onebuy.core.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vanroid.onebuy.entity.Category;
import com.vanroid.onebuy.service.CategoryService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class InitDataTest {
	@Autowired
	private CategoryService categoryService;

	/**
	 * 初始化数据 方便测试
	 */
	@Test
	public void initData() {
		initCategoryData();
	}
	
	public void initCategoryData(){
		List<Category> categoryList = new ArrayList<Category>();
		Category category = new Category();
		category.setName("手机数码");
		categoryList.add(category);
		
		category = new Category();
		category.setName("广金特色");
		categoryList.add(category);
		
		category = new Category();
		category.setName("日常生活");
		categoryList.add(category);
		
		// 初始化分类
		categoryService.saveOrUpdateAll(categoryList);
		Assert.assertNotNull(categoryList.get(0).getId());
	}

	public void initGoodData(){
		
	}
	
	public void initStage(){
		
	}
	
	public void initLuckShow(){
		
	}
}
