package com.vanroid.onebuy.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vanroid.onebuy.entity.Code;
import com.vanroid.onebuy.entity.Order;
import com.vanroid.onebuy.entity.Stage;
import com.vanroid.onebuy.entity.User;
import com.vanroid.onebuy.util.LotteryUtil;

/**
*@author kaiscript
*@date 2016年2月1日 下午7:49:32
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
@Transactional
public class LotteryDaoTest {
	
	@Resource(name = "stageDao")
	private StageDao stageDao;
	@Resource(name = "orderDao")
	private OrderDao orderDao;
	@Resource(name = "codeDao")
	private CodeDao codeDao;
	@Resource(name = "userDao")
	private UserDao userDao;
	//生成某期所有抽奖码测试
	/*@Test
	public void test1(){
		Stage stage = stageDao.get((long) 1);
		for(Code c:stage.getCodes()){
			System.out.println("c:"+c.getCode());
		}
	}*/
	
	//为订单分配抽奖码测试
	@Test
	public void test2(){
		Order order = orderDao.get((long)2);
		User ownedUser = order.getUserDetail().getUser();
		System.out.println("userId"+ownedUser.getId());
		int quantity = order.getPurchasedQuantity();//购买的份数
		Stage stage = order.getStage();
		System.out.println(stage+"qwer"+stage.getId());
		Object[] values = new Object[1];
		values[0] = stage;
		String queryString="FROM Code c WHERE c.stage=?";
		//为订单赋予抽奖码(数量>=1)
		List<Code> codesList = codeDao.find(queryString, values, stage.getPurchasedQuantity(), quantity);
		for(Code code:codesList){
			code.setOwnedUser(ownedUser);
			code.setOrder(order);
			System.out.println("code:"+code.getCode()+"---"+code.getOrder().getPurchasedQuantity());
		}
		Set<Code> codes = new HashSet<Code>(codesList);
		//codeDao.saveOrUpdateAll(codes);  //order级联有更新到
		order.setCodes(codes);
		orderDao.saveOrUpdate(order);
		Order oo = orderDao.get((long)2);
		for(Code c:oo.getCodes()){
			System.out.println("after:"+c.getCode());
		}
			
	}
	
	//分配幸运码测试
	/*
	@Test
	public void test(){
		Stage stage = stageDao.get((long)1);
		List<Date> dates = new ArrayList<Date>();
		String queryString = "FROM Order o WHERE o.stage=? ORDER BY o.id asc";
		Object[] values = new Object[1];
		values[0] = stage;
		List<Order> orders = orderDao.find(queryString, values, 6, 10);
		for(Order o:orders){
			dates.add(o.getTime());
		}
		String luckyCode = LotteryUtil.getLuckyCode(dates, stage.getQuantity());
		System.out.println("luckyCode"+luckyCode);
		String queryLuckyUser = "SELECT code.ownedUser FROM Code code WHERE code.code=?";
		User user = userDao.findFirst(queryLuckyUser, luckyCode);
//		User user = luckyUser.get(0);
		stage.setLuckyCode(luckyCode);
		stage.setLuckyUser(user);
		stage.setStatus(3);  //已揭晓
		stageDao.saveOrUpdate(stage);
	}*/
	
}
