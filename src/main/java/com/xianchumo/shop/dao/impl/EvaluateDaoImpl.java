package com.xianchumo.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xianchumo.shop.dao.EvaluateDao;
import com.xianchumo.shop.entity.Evaluate;
@Repository(value="evaluateDao")
public class EvaluateDaoImpl extends BaseDaoImpl<Evaluate> 
	implements EvaluateDao{
	public static int SIZE = 20;
	@Override
	public List<Evaluate> findBuMerchant(Long merchantId, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
