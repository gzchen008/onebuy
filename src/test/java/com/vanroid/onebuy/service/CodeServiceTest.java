package com.vanroid.onebuy.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vanroid.onebuy.entity.Code;
import com.vanroid.onebuy.entity.Order;
import com.vanroid.onebuy.entity.Stage;

/**
*@author kaiscript
*@date 2016年1月30日 下午5:22:19
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class CodeServiceTest {
	
	@Autowired
	private CodeService codeService;
	@Autowired
	private StageService stageService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private LotteryService lotteryService;
	/*@Test
	public void saveTest(){
		Stage stage = stageService.get(1l);
		Code code = new Code();
		Code code1 = new Code();
		code1.setCode("aaa");
		code1.setStage(stage);
		code.setCode("bbb");
		code.setStage(stage);
		Set<Code> codes = new HashSet<Code>();
		codes.add(code);
		codes.add(code1);
		codeService.saveOrUpdateAll(codes);
	}	
	*/
	//测试生成分发抽奖码给订单，parameters:  stage , order
	/*@Test
	public void pushCodeTest(){
		Stage stage = stageService.getLastStageByGoodId(1l);
		Order order = orderService.get(1l);
		//生成相应期所有抽奖码
		Set<Code> codes = codeService.createCodesByStage(stage);
		for(Code c:codes){
			System.out.println(c.getCode());
		}
		codeService.saveOrUpdateAll(codes);
		stage.setCodes(codes);
		stageService.update(stage);
		//赋予order订单抽奖码
		Set<Code> getCodes = codeService.getCodesByStageAndOrder(stage, order);
		order.setCodes(getCodes);
		orderService.update(order);
		System.out.println("--");
		for(Code c:orderService.get(1l).getCodes()){
			System.out.println(c.getCode());
		}
		
	}*/
	
	@Test
	public void luckyCodeTest(){
		Stage stage = stageService.get(1);
//		lotteryService.createCodesByStage(1);
		lotteryService.pushCodesToOrder(2);
//		lotteryService.lotteryLuckyCode(1);
		
	}
	
	/*@Test
	public void orderCodeTest(){
		Order order = orderService.get((long)1);
		Stage stage = stageService.get(1);
		System.out.println("--");
		for(Code c:order.getCodes()){
			System.out.println("++++");
			System.out.println(c.getCode());
		}
	}*/
}
