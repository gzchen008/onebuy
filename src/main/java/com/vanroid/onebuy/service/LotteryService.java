package com.vanroid.onebuy.service;

import com.vanroid.onebuy.entity.Order;
import com.vanroid.onebuy.entity.Stage;

/**
*@author kaiscript
*@date 2016年2月1日 下午3:03:36
*/
public interface LotteryService extends BaseService<Stage> {
	/**
	 * 生成所有抽奖码并保存
	 * @param stageId
	 */
	void createCodesByStage(int stageId);
	/**
	 * 为订单赋予抽奖码
	 * @param order
	 */
	void pushCodesToOrder(int orderId);
	/**
	 * 揭晓幸运码
	 * @param stageId
	 */
	void lotteryLuckyCode(int stageId);
	
	
}
