package com.vanroid.onebuy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vanroid.onebuy.dao.BaseDao;
import com.vanroid.onebuy.dao.GlobalConfigDao;
import com.vanroid.onebuy.entity.GlobalConfig;
import com.vanroid.onebuy.service.GlobalConfigService;

@Service("globalConfigService")
public class GlobalConfigServiceImpl extends BaseServiceImpl<GlobalConfig> implements GlobalConfigService {
	private GlobalConfigDao globalConfigDao;

	@Override
	@Resource(name = "globalConfigDao")
	public void setDao(BaseDao<GlobalConfig> dao) {
		super.setDao(dao);
		this.globalConfigDao = (GlobalConfigDao) dao;
	}
}
