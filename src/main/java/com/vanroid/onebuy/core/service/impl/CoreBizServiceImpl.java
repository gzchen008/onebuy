package com.vanroid.onebuy.core.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.vanroid.onebuy.core.holder.StageHolder;
import com.vanroid.onebuy.core.service.CoreBizService;
import com.vanroid.onebuy.entity.Code;
import com.vanroid.onebuy.entity.Good;
import com.vanroid.onebuy.entity.Stage;
import com.vanroid.onebuy.service.CodeService;
import com.vanroid.onebuy.service.StageService;
import com.vanroid.onebuy.util.DateUtil;

/**
 * 
 * @company vanroid.com
 * @author cgz
 * @date 2016年1月23日
 * @version 1.0
 * @description 核心业务服务
 */
@Service("coreBizService")
public class CoreBizServiceImpl implements CoreBizService {
	@Resource(name = "codeService")
	private CodeService codeService;
	@Resource(name = "stageService")
	private StageService stageService;

	/** 进行中的期 */
	@Resource(name = "processStageHolder")
	private StageHolder processStageHolder;

	@Override
	public Set<Code> getAllCode(Stage stage) {
		// 在缓存中找
		Set<Code> codes = getAllCodeInCache(stage);
		if (codes == null || codes.size() == 0) {
			// 在数据库中找
			codes = getAllCodeInPersistent(stage);
		}
		if (codes == null || codes.size() == 0) {
			// 创建保存至数据库和缓存
			codes = createCodeByStage(stage);
		}
		return codes;
	}

	private Set<Code> createCodeByStage(Stage stage) {
		long stageId = stage.getGood().getId();
		int quantity = stage.getQuantity().intValue();
		Set<Code> codeList = new HashSet<Code>();
		for (int i = 1; i <= quantity; i++) {
			Code code = new Code();
			code.setCode("" + stageId + i);
			code.setStage(stage);
			codeList.add(code);
		}
		// insert into database
		codeService.saveOrUpdateAll(codeList);
		stage.setCodes(codeList);
		return codeList;
	}

	private Set<Code> getAllCodeInPersistent(Stage stage) {
		return codeService.findByStage(stage);
	}

	private Set<Code> getAllCodeInCache(Stage stage) {
		return processStageHolder.get(stage.getId()).getCodes();
	}

	@Override
	@Transactional
	public void pushGoodStage(Good good, Stage stage) {
		// 添加stage
		stage.setGood(good);
		stage.setCreateTime(DateUtil.getDate());
		stage.setNum(stageService.getLastStageNum(good.getId()) + 1);
		stageService.add(stage);

		// 添加和stage相关的code
		createCodeByStage(stage);

		// 添加进缓存
		processStageHolder.add(stage);
	}

	@Override
	public void getAllGoods() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sell(Stage stage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void announce(Stage stage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateNotify(int action) {
		// TODO Auto-generated method stub
		
	}
}
