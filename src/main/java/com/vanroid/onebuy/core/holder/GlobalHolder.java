package com.vanroid.onebuy.core.holder;

import javax.annotation.Resource;

import com.vanroid.onebuy.entity.GlobalConfig;
import com.vanroid.onebuy.service.GlobalConfigService;

/**
 * 
 * @company vanroid.com
 * @author cgz
 * @date 2016年2月10日
 * @version 1.0
 * @description 全局信息緩存
 */
public class GlobalHolder {
	private GlobalConfig globalConfig;
	@Resource(name = "globalConfigService")
	private GlobalConfigService globalConfigService;

	public GlobalConfig getGlobalConfig() {
		if (globalConfig == null) {
			globalConfig = globalConfigService.get(1);
		}
		return globalConfig;
	}

	public void setGlobalConfig(GlobalConfig globalConfig) {
		this.globalConfig = globalConfig;
	}

}
