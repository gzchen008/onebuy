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
public class StageServiceTest {
	
	@Autowired
	private StageService stageService;
	
	
	@Test
	public void goodPicTest(){
		 Integer lastNum = stageService.getLastStageNum(1l);
		 System.out.println(lastNum);
	}
	
}
