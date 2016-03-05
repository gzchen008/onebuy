package com.vanroid.onebuy.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vanroid.onebuy.dao.BaseDao;
import com.vanroid.onebuy.entity.LuckShow;
import com.vanroid.onebuy.entity.User;
import com.vanroid.onebuy.service.LuckShowService;

/**
 * 
 * @company vanroid.com
 * @author cgz
 * @date 2016年3月5日
 * @version 1.0
 * @description TODO
 */
@Service("luckShowService")
public class LuckShowServiceImpl extends BaseServiceImpl<LuckShow> implements LuckShowService {

	@Override
	@Resource(name = "luckShowDao")
	public void setDao(BaseDao<LuckShow> dao) {
		super.setDao(dao);
	}

}
