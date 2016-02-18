package com.vanroid.onebuy.service;

import java.util.List;

import com.vanroid.onebuy.common.Pager;
import com.vanroid.onebuy.entity.Stage;

/**
*@author kaiscript
*@date 2016年1月22日 下午6:08:24
*/
public interface StageService extends BaseService<Stage> {

	/**
	 * 获取某商品最后一期期数
	 * @param goodIdl 
	 * @return
	 */
	Integer getLastStageNum(Long goodId);
	
	/**
	 * 获取某商品最新一期
	 * @param goodId
	 * @return
	 */
	Stage getLastStageByGoodId(Long goodId);
	
	/**
	 * 根据Stage实体获取 stage 
	 * @param stage
	 * @return
	 */
	Stage findByExampleStage(Stage stage) ;
	/**
	 * 获取进行中的期
	 * @return
	 */
	List<Stage> getProcessingStages();
	/**
	 * 根据分页实例获取进行中的"期 
	 * @return
	 */
	Pager getProcessingStagesPagerByPager(Pager pager);
	
	/**
	 * 模糊查询商品名的所有"期分页实例"
	 * @param pager
	 * @return
	 */
	Pager getStagesFuzzyPagerByPager(String goodName,Pager pager);
	/**
	 * 模糊查询商品名的所有进行中的"期 分页实例"
	 * @param goodName
	 * @param pager
	 * @return
	 */
	Pager getProcessingStagesFuzzyPagerByPager(String goodName,Pager pager);
}
