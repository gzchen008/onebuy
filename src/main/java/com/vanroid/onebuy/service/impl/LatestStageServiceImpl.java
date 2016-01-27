package com.vanroid.onebuy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vanroid.onebuy.dao.BaseDao;
import com.vanroid.onebuy.dao.LatestStageDao;
import com.vanroid.onebuy.entity.Good;
import com.vanroid.onebuy.entity.LatestStage;
import com.vanroid.onebuy.service.LatestStageService;

/**
*@author kaiscript
*@date 2016年1月27日 下午8:33:59
*/
@Service("latestStageService")
public class LatestStageServiceImpl extends BaseServiceImpl<LatestStage> implements LatestStageService {
	
	private LatestStageDao latestStageDao;
	
	@Override
	@Resource(name = "latestStageDao")
	public void setDao(BaseDao<LatestStage> dao) {
		super.setDao(dao);
		this.latestStageDao = (LatestStageDao)dao;
	}

	
	@Override
	public LatestStage getLatestStageByGood(Good good) {
		List<LatestStage> stages = latestStageDao.find("from LatestStage ls where ls.good = ?",good);
		LatestStage latestStage = new LatestStage();
		for(LatestStage ls:stages){
			latestStage = ls;
		}
		return latestStage;
	}
	
}
