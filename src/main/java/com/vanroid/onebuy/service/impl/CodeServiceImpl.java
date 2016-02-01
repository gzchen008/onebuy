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

}
