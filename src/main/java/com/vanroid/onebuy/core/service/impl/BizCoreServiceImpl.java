package com.vanroid.onebuy.core.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.vanroid.onebuy.common.BizConstant;
import com.vanroid.onebuy.core.holder.GlobalHolder;
import com.vanroid.onebuy.core.holder.StageHolder;
import com.vanroid.onebuy.core.service.BizCoreService;
import com.vanroid.onebuy.entity.Category;
import com.vanroid.onebuy.entity.Code;
import com.vanroid.onebuy.entity.Good;
import com.vanroid.onebuy.entity.Order;
import com.vanroid.onebuy.entity.Stage;
import com.vanroid.onebuy.entity.User;
import com.vanroid.onebuy.service.CategoryService;
import com.vanroid.onebuy.service.CodeService;
import com.vanroid.onebuy.service.GoodService;
import com.vanroid.onebuy.service.LotteryService;
import com.vanroid.onebuy.service.OrderService;
import com.vanroid.onebuy.service.StageService;
import com.vanroid.onebuy.util.DateUtil;

/**
 * 
 * @company vanroid.com
 * @author cgz
 * @date 2016年1月23日
 * @version 1.0
 * @description 核心业务服务
 */
@Service("bizCoreService")
public class BizCoreServiceImpl implements BizCoreService {
	@Resource(name = "codeService")
	private CodeService codeService;
	@Resource(name = "stageService")
	private StageService stageService;
	@Resource(name = "globalHolder")
	private GlobalHolder globalHolder;
	@Resource(name = "categoryService")
	private CategoryService categoryService;
	@Resource(name = "lotteryService")
	private LotteryService lotteryService;
	@Resource
	private GoodService goodService;
	@Resource(name = "orderService")
	private OrderService orderService;

	@Override
	public List<Category> getGoodCategoryList() {
		List<Category> categoryList = (List<Category>) globalHolder.get(GlobalHolder.GOOD_CATEGORY_LIST);
		if (categoryList == null) {
			categoryList = categoryService.findAll();
			globalHolder.set(GlobalHolder.GOOD_CATEGORY_LIST, categoryList);
		}
		return categoryList;
	}

	@Override
	public Order makeOrder(Stage stage, Integer quantity, User user) {
		Order order = new Order();
		order.setPurchasedQuantity(quantity);
		order.setStatus(BizConstant.ORDER_STATUS_DEFAULT);
		order.setStage(stage);
		order.setUserDetail(user.getUserDetail());
		order.setOrderTime(new Date());

		orderService.add(order);
		return order;
	}

	@Override
	public Boolean pay(Order order) {

		// TODO 整理微信支付数据，跳至微信支付
		// prePay

		return true;
	}

	@Override
	public void payNotify(Long orderId) {
		// 分配Code
		lotteryService.pushCodesToOrder(orderId);
		// 修改支付状态
		Order order = orderService.load(orderId);
		order.setStatus(BizConstant.ORDER_STATUS_PAID);
		orderService.update(order);

	}

	@Override
	public Stage getStageDetailByProduct(Long productId) {
		Stage stage = stageService.get(productId);
		if (stage == null) {
			Good good = goodService.get(productId);
			stage = new Stage();
			stage.setGood(good);
		}
		return stage;
	}

	@Override
	public void getAllGoods() {
		// TODO Auto-generated method stub

	}
}
