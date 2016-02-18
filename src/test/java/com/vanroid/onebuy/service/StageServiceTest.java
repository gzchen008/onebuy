package com.vanroid.onebuy.service;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vanroid.onebuy.common.Pager;

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
	@Autowired
	private CodeService codeService;
	@Autowired
	private UserService userService;
	/*@Test
	public void goodPicTest(){
		 Integer lastNum = stageService.getLastStageNum(1l);
		 Stage stage = stageService.getLastStageByGoodId(1l);
		 System.out.println(stage.getQuantity());
		 System.out.println(lastNum);
	}*/
	
	
	/*@Test
	public void stageTest(){
		List<Stage> stages = stageService.getProcessingStages();
		int i=0;
		for(Stage s:stages){
			System.out.println(":"+s.getGood().getName());
			i++;
			System.out.println(i);
		}
	}*/
	
	/*@Test
	public void stageToGoodTest(){
		Stage stage = stageService.get(5l);
		Good good = stage.getGood();
		Set<Stage> stages =good.getStages();
		for(Stage s:stages){
			System.out.println(s.getId());
			System.out.println(s.getStatus());
			System.out.println("__------");
		}
	}*/
	
	/*@Test
	public void processingStagePager(){
		Pager pager = new Pager();
		pager.setPageIndex(2);
		pager.setPageSize(1);
		List<Stage> stages = (List<Stage>) stageService.getProcessingStagesPagerByPager(pager).getDatas();
		for(Stage s:stages){
			System.out.println(s.getId());
		}
		
	}*/
	
	
	/*@Test
	public void getCodeTest(){
		Stage stage = stageService.get(1l);
		Set<Code> codes = stage.getCodes();
		for(Code c:codes){
			System.out.println(c.getCode());
		}
		User user = userService.get((long)1);
		stage.setLuckyUser(user);
		for(Code c:stage.getCodes()){
			System.out.println(c.getCode());
		}
	}*/
	
	/*@Test
	public void stageFuzzyTest(){
		Pager pager = new Pager();
		pager = stageService.getStagesFuzzyPagerByPager("6", pager);
	}*/
	
	@Test
	public void processinStageFuzzyTest(){
		Pager pager = new Pager();
		pager.setPageIndex(1);
		pager.setPageSize(4);
		pager = stageService.getProcessingStagesFuzzyPagerByPager("5", pager);
	}
}
