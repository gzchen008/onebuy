package com.vanroid.onebuy.service;

import com.vanroid.onebuy.entity.Good;
import com.vanroid.onebuy.entity.LatestStage;

/**
*@author kaiscript
*@date 2016年1月27日 下午8:33:18
*/
public interface LatestStageService extends BaseService<LatestStage> {
	
	LatestStage getLatestStageByGood(Good good);
}
