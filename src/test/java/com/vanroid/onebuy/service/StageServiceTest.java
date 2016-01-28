package com.vanroid.onebuy.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vanroid.onebuy.entity.Good;
import com.vanroid.onebuy.entity.Stage;

/**
*@author kaiscript
*@date 2016年1月22日 下午12:40:13
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
@Transactional
public class StageServiceTest {
	
	@Autowired
	private StageService stageService;
	
	
	/*@Test
	public void goodPicTest(){
		 Integer lastNum = stageService.getLastStageNum(1l);
		 Stage stage = stageService.getLastStageByGoodId(1l);
		 System.out.println(stage.getQuantity());
		 System.out.println(lastNum);
	}*/
	
	@Test
	public void stageTest(){
		List<Stage> stages = stageService.getProcessingStages();
		int i=0;
		for(Stage s:stages){
			System.out.println(":"+s.getGood().getName());
			i++;
			System.out.println(i);
		}
	}
	
	
}
