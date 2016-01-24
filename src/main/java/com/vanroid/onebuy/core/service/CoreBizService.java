package com.vanroid.onebuy.core.service;

import java.util.Set;

import com.vanroid.onebuy.entity.Code;
import com.vanroid.onebuy.entity.Good;
import com.vanroid.onebuy.entity.Stage;

public interface CoreBizService {

	/**
	 * <p>
	 * 
	 * 根据期数ID获取，当期所有抽奖代码
	 * 调用该方法前,stage已是持久化对象
	 * @param stageId
	 * @return
	 */
	Set<Code> getAllCode(Stage stage);
	
	/**
	 *  发布商品的某一期
	 *  注意：调用该方法前，stage已通过表单接收了相关的信息，如价格
	 * @param good
	 * @param stage
	 */
	void pushGoodStage(Good good,Stage stage);
	
	/**
	 * 获得所有商品列表
	 */
	void getAllGoods();
	
}
