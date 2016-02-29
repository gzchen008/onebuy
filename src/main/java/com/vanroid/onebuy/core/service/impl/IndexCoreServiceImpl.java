package com.vanroid.onebuy.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vanroid.onebuy.core.holder.GlobalHolder;
import com.vanroid.onebuy.core.service.IndexCoreService;
import com.vanroid.onebuy.dao.GoodDao;
import com.vanroid.onebuy.dao.StageDao;
import com.vanroid.onebuy.entity.CarouselAds;
import com.vanroid.onebuy.entity.GlobalConfig;
import com.vanroid.onebuy.entity.Good;
import com.vanroid.onebuy.entity.Stage;
import com.vanroid.onebuy.service.GlobalConfigService;

@Service("indexCoreService")
public class IndexCoreServiceImpl implements IndexCoreService {
	@Resource(name = "globalConfigService")
	private GlobalConfigService globalConfigService;
	@Resource(name = "globalHolder")
	private GlobalHolder globalHolder;
	@Resource(name = "goodDao")
	private GoodDao goodDao;
	@Resource(name="stageDao")
	private StageDao stageDao;
	@Override
	public List<CarouselAds> getCarouselAdsList() {
		GlobalConfig globalConfig = (GlobalConfig) globalHolder.get(GlobalHolder.GLOBAL_CONFIG);
		if (globalConfig == null) {
			globalConfig = globalConfigService.get(GlobalConfigService.DEFAULT_CONFIG_ID);
			globalHolder.set(GlobalHolder.GLOBAL_CONFIG, globalConfig);
		}
		return globalConfig.getCarouselAds();
	}

	@Override
	public List<Good> getRecommendGoodList(int pageNum) {
		StringBuilder hql = new StringBuilder();
		hql.append("FROM Good ");
		return goodDao.find(hql.toString(), pageNum * IndexCoreService.RECOMD_PAGE_SIZE, IndexCoreService.RECOMD_PAGE_SIZE);
	}

	@Override
	public List<Stage> getRecommendStageList(int pageNum) {
		String queryString = "FROM Stage s where s.recommend = true  ";
		return stageDao.find(queryString, pageNum * IndexCoreService.RECOMD_PAGE_SIZE, IndexCoreService.RECOMD_PAGE_SIZE);
	}

}
