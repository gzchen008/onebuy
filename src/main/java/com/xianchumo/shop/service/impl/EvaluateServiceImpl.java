package com.xianchumo.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xianchumo.shop.dao.BaseDao;
import com.xianchumo.shop.dao.EvaluateDao;
import com.xianchumo.shop.entity.Evaluate;
import com.xianchumo.shop.service.EvaluateService;
/**
 * 
 * Copyright 2015 xianchumo.com
 * @Team xianchumo
 * @data：2015年9月19日
 * @author CGZ
 * @description
 */
@Service("evaluateService")
@Transactional
public class EvaluateServiceImpl extends BaseServiceImpl<Evaluate>
	implements EvaluateService{
	private EvaluateDao evaluateDao;
	@Resource(name="evaluateDao")
	public void setDao(BaseDao<Evaluate> dao){
		super.setDao(dao);
		evaluateDao = (EvaluateDao)dao;
	}

	@Override
	public List<Evaluate> findByMerchant(Long merchantId, int page) {
		return evaluateDao.findByMerchant(merchantId, page);
	}
	
}
