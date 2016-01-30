package com.vanroid.onebuy.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vanroid.onebuy.dao.BaseDao;
import com.vanroid.onebuy.dao.CodeDao;
import com.vanroid.onebuy.entity.Code;
import com.vanroid.onebuy.entity.Order;
import com.vanroid.onebuy.entity.Stage;
import com.vanroid.onebuy.service.CodeService;
import com.vanroid.onebuy.util.LotteryUtil;

/**
 * 
 * @company vanroid.com
 * @author cgz
 * @date 2016年1月23日
 * @version 1.0
 * @description TODO
 */
@Service("codeService")
public class CodeServiceImpl extends BaseServiceImpl<Code> implements CodeService {

	private CodeDao codeDao;

	@Override
	@Resource(name = "codeDao")
	public void setDao(BaseDao<Code> dao) {
		super.setDao(dao);
		this.codeDao = (CodeDao) dao;
	}

	@Override
	public Set<Code> findByStage(Stage stage) {
		List<Code> codes = codeDao.find("from Code c where c.stage = ?", stage);
		return new HashSet<Code>(codes);
	}

	@Override
	public Set<Code> createCodesByStage(Stage stage) {
		String[] codeStrs = LotteryUtil.getAllCodeByQuantity(stage.getQuantity());
		Set<Code> stageCodes = new HashSet<Code>();
		for(String c:codeStrs){
			Code code = new Code();
			code.setCode(c);
			code.setStage(stage);
			stageCodes.add(code); 
		}
		
		return stageCodes;
	}

	@Override
	public Set<Code> getCodesByStageAndOrder(Stage stage,Order order) {
		int quantity = order.getPurchasedQuantity();//购买的份数
		Object[] values = new Object[1];
		values[0] = stage;
		String queryString="FROM Code c WHERE c.stage=?";
		
		List<Code> codes = dao.find(queryString, values, stage.getPurchasedQuantity(), order.getPurchasedQuantity());
		return new HashSet<Code>(codes);
	}
	
}
