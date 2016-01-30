package com.vanroid.onebuy.service;

import java.util.Set;

import com.vanroid.onebuy.entity.Code;
import com.vanroid.onebuy.entity.Order;
import com.vanroid.onebuy.entity.Stage;

/**
 * 
*  @company vanroid.com
 * @author cgz
 * @date 2016年1月23日
 * @version 1.0
 * @description TODO
 */
public interface CodeService extends BaseService<Code>{

	Set<Code> findByStage(Stage stage);
	
	/**
	 * 生成并获取某期所有抽奖码 (抽奖码没有存入数据库)
	 * @param stage
	 * @return
	 */
	Set<Code> createCodesByStage(Stage stage);
	/**
	 * 获取订单的抽奖码
	 * @param stage
	 * @param order
	 * @return
	 */
	Set<Code> getCodesByStageAndOrder(Stage stage,Order order);
}
