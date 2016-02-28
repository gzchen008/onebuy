package com.vanroid.onebuy.dao.impl;

import org.springframework.stereotype.Repository;

import com.vanroid.onebuy.dao.GlobalConfigDao;
import com.vanroid.onebuy.entity.GlobalConfig;

@Repository("globalConfigDao")
public class GlobalConfigDaoImpl extends BaseDaoImpl<GlobalConfig> implements GlobalConfigDao{

}
