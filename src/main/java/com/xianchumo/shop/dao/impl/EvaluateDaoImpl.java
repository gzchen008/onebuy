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
	public List<Evaluate> findByMerchant(Long merchantId, int page) {
		StringBuilder query = new StringBuilder(64);
		query.append("FROM Evaluate WHERE merchant_id=")
		     .append(merchantId.toString());
		return find(query.toString(), (page-1)*SIZE, SIZE);
	}

	
	
}
