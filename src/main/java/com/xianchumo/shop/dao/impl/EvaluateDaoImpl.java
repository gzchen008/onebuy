package com.xianchumo.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xianchumo.shop.dao.EvaluateDao;
import com.xianchumo.shop.entity.Evaluate;
import com.xianchumo.shop.entity.PageObj;
@Repository(value="evaluateDao")
public class EvaluateDaoImpl extends BaseDaoImpl<Evaluate> 
	implements EvaluateDao{
	public static int pageSize = 15;
	@Override
	public PageObj<Evaluate> findByMerchant(Long merchantId, int page) {
		StringBuilder total = new StringBuilder(64);
		total.append("select count(eid) from Evaluate where merchant_id=")
		     .append(merchantId.toString());
		Long totalCount = totalCount(total.toString());
		if(totalCount != 0){
			StringBuilder query = new StringBuilder(64);
			query.append("from Evaluate where merchant_id=")
			     .append(merchantId.toString());
			List<Evaluate> list = find(query.toString(), (page-1)*pageSize, pageSize);
			if(list != null && list.size() != 0){
				return new PageObj<Evaluate>(list, totalCount, pageSize, page);
			}
		}
		return null;
	}
	@Override
	public PageObj<Evaluate> fidByGood(Long gid, int size, int page) {
		return null;
	}

	
	
}
