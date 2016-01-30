package com.vanroid.onebuy.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vanroid.onebuy.entity.Code;
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
	@Autowired
	private CodeService codeService;
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
	
	//生成抽奖码
	@Test
	public void setStageCodeTest(){
		Stage stage = stageService.get(1l);
		Set<Code> codes = codeService.createCodesByStage(stage);
		
		codeService.saveOrUpdateAll(codes);
		stage.setCodes(codes);
		stageService.update(stage);
		
		for(Code c:stageService.get(1l).getCodes()){
			System.out.println(c.getCode());
		}
	}
	
	/*@Test
	public void getCodeTest(){
		Stage stage = stageService.get(1l);
		Set<Code> codes = stage.getCodes();
		for(Code c:codes){
			System.out.println(c.getCode());
		}
	}*/
}
