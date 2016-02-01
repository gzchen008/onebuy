package com.vanroid.onebuy.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vanroid.onebuy.dao.BaseDao;
import com.vanroid.onebuy.dao.CodeDao;
import com.vanroid.onebuy.dao.OrderDao;
import com.vanroid.onebuy.dao.StageDao;
import com.vanroid.onebuy.dao.UserDao;
import com.vanroid.onebuy.entity.Code;
import com.vanroid.onebuy.entity.Order;
import com.vanroid.onebuy.entity.Stage;
import com.vanroid.onebuy.entity.User;
import com.vanroid.onebuy.service.LotteryService;
import com.vanroid.onebuy.util.LotteryUtil;

/**
*@author kaiscript
*@date 2016年2月1日 下午3:05:57
*/
@Service("lotteryService")
public class LotteryServiceImpl extends BaseServiceImpl<Stage> implements LotteryService {
	
	private StageDao stageDao;
	private OrderDao orderDao;
	private CodeDao codeDao;
	
	@Override
	@Resource(name = "stageDao")
	public void setDao(BaseDao<Stage> dao) {
		super.setDao(dao);
		this.stageDao = (StageDao) dao;
	}
	
	@Resource(name = "orderDao")
	public void setOrderDao(BaseDao<Order> orderDao){
		this.orderDao = (OrderDao) orderDao;
	}
	@Resource(name = "codeDao")
	public void setCodeDao(BaseDao<Code> codeDao){
		this.codeDao = (CodeDao) codeDao;
	}
	
	@Override
	public void createCodesByStage(int stageId) {
		Stage stage = stageDao.get((long) stageId);
		//根据“期”的份数生成所有抽奖码
		String[] codeStrs = LotteryUtil.getAllCodeByQuantity(stage.getQuantity());
		Set<Code> stageCodes = new HashSet<Code>();
		for(String c:codeStrs){
			Code code = new Code();
			code.setCode(c);
			code.setStage(stage);
			stageCodes.add(code); 
		}
		codeDao.saveOrUpdateAll(stageCodes);  //保存 生成的抽奖码
		stage.setCodes(stageCodes);
		stageDao.saveOrUpdate(stage);  //设“期” 的所有抽奖码并保存
		
	}
	
	
	@Override
	public void pushCodesToOrder(int orderId) {
		Order order = orderDao.get((long) orderId);
		User ownedUser = order.getUserDetail().getUser(); //得到订单所属用户
		int quantity = order.getPurchasedQuantity();//此订单购买的份数
		Stage stage = order.getStage();
		Object[] values = new Object[1];
		values[0] = stage;
		String queryString="FROM Code c WHERE c.stage=?";
		//为订单随机分配抽奖码(数量>=1)
		List<Code> codesList = codeDao.find(queryString, values, stage.getPurchasedQuantity(), quantity);
		for(Code code:codesList){
			code.setOwnedUser(ownedUser);  //为抽奖码设置所属用户
			code.setOrder(order);
		}
		Set<Code> codes = new HashSet<Code>(codesList);
		order.setCodes(codes);
		orderDao.saveOrUpdate(order);  //保存订单的抽奖码
//		codeDao.saveOrUpdateAll(codes); 
	}

	@Override
	public void lotteryLuckyCode(int stageId) {
		Stage stage = stageDao.get((long) stageId);
		List<Date> dates = new ArrayList<Date>();
		String queryString = "FROM Order o WHERE o.stage=? ORDER BY o.id asc";
		Object[] values = new Object[1];
		values[0] = stage;
		List<Order> orders = orderDao.find(queryString, values, 6, 10);
		for(Order o:orders){
			dates.add(o.getTime());  //提取 第7-第10个订单的下单时间
		}
		//幸运码
		String luckyCode = LotteryUtil.getLuckyCode(dates, stage.getQuantity());
		String queryLuckyUser = "SELECT code.ownedUser FROM Code code WHERE code=?";
		User luckyUser = (User) codeDao.find(queryLuckyUser, luckyCode);
		stage.setLuckyCode(luckyCode);
		stage.setLuckyUser(luckyUser);  //设置幸运儿
		stage.setStatus(3);  //设置已揭晓
		stageDao.saveOrUpdate(stage);
	}
	
}
