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
	@Autowired
	private StageService stageService;
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
	
	/*@Test
	public void goodPicTest(){
		Good good = goodService.get(22);
		String[] pics= good.getDetailPhotos();
		pics = PhotosStringUtil.addPhotoUrl(pics, "http://kaiscript-10009183.image.myqcloud.com/8c7e618d-07d1-42ff-a16e-d1ab639612b2");
		good.setDetailPhotos(pics);
		goodService.update(good);
		for(String pic:good.getDetailPhotos()){
			System.out.println(pic);
		}
		
	}*/
	
	/*@Test
	public void goodCreateStage(){
		Good good = goodService.get(7);
		int num = good.getStages().size()+1;
		int itotalPrice = Integer.valueOf(30);
		int iquantity = Integer.valueOf(15);
		
		
	}*/
	
	@Test
	public void getGoodTest(){
		Good good = goodService.get(1);
		goodService.delete(good);
	}
}
