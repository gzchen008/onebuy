package com.vanroid.onebuy.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vanroid.onebuy.entity.Good;

/**
*@author kaiscript
*@date 2016年1月22日 下午12:40:13
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class GoodServiceTest {
	
	@Autowired
	private GoodService goodService;
	
	
	/*@Test
	public void goodTest(){
		
		Good good = goodService.get(2);
		System.out.println(good.getName());
		
		System.out.println(!Hibernate.isInitialized(good.getStages()));
		
		Set<Stage> stages = goodService.get(2).getStages();
		for(Stage s:stages){
			System.out.println(s.getNum());
		}
		
		
	}*/
	
	@Test
	public void goodPicTest(){
		Good good = goodService.get(1);
		String[] pics= good.getDetailPhotos();
		for(String pic:pics){
			System.out.println(pic);
		}
	}
	
}
