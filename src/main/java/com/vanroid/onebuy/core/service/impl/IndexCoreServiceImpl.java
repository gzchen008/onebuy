package com.vanroid.onebuy.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vanroid.onebuy.core.holder.GlobalHolder;
import com.vanroid.onebuy.core.service.IndexCoreService;
import com.vanroid.onebuy.entity.CarouselAds;
import com.vanroid.onebuy.entity.GlobalConfig;
import com.vanroid.onebuy.service.GlobalConfigService;

@Service("indexCoreService")
public class IndexCoreServiceImpl implements IndexCoreService {
	@Resource(name = "globalConfigService")
	private GlobalConfigService globalConfigService;
	@Resource(name = "globalHolder")
	private GlobalHolder globalHolder;

	@Override
	public List<CarouselAds> getCarouselAdsList() {
		GlobalConfig globalConfig = (GlobalConfig) globalHolder.get(GlobalHolder.GLOBAL_CONFIG);
		if (globalConfig == null) {
			globalConfig = globalConfigService.get(GlobalConfigService.DEFAULT_CONFIG_ID);
			globalHolder.set(GlobalHolder.GLOBAL_CONFIG, globalConfig);
		}
		return globalConfig.getCarouselAds();
	}

}
