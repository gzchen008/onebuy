package com.vanroid.onebuy.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vanroid.onebuy.common.Pager;
import com.vanroid.onebuy.dao.BaseDao;
import com.vanroid.onebuy.entity.Code;
import com.vanroid.onebuy.entity.Stage;
import com.vanroid.onebuy.service.StageService;
import com.vanroid.onebuy.util.LotteryUtil;

/**
 * @author kaiscript
 * @date 2016年1月22日 下午6:09:13
 */
@Service("stageService")
public class StageServiceImpl extends BaseServiceImpl<Stage> implements StageService {

	@Override
	@Resource(name = "stageDao")
	public void setDao(BaseDao<Stage> dao) {
		super.setDao(dao);
	}

	@Override
	public Integer getLastStageNum(Long goodId) {
		String queryString = "SELECT stage.num FROM Stage stage WHERE stage.good.id = ? ORDER BY stage.id DESC";
		return dao.findFirst(queryString, goodId);
	}

	@Override
	public Stage getLastStageByGoodId(Long goodId) {
		String queryString = "FROM Stage s WHERE s.good.id = ? ORDER BY s.id DESC";
		Stage stage = dao.findFirst(queryString, goodId);
			return stage;
	}

	@Override
	public Stage findByExampleStage(Stage stage) {
		List<Stage> stages = dao.findByExampleEntity(stage);
		return stages.get(0);
	}

	@Override
	public List<Stage> getProcessingStages() {
		String queryString = "FROM Stage s WHERE s.status = 1 OR s.status = 2 ORDER BY s.id DESC";
		return dao.find(queryString);
	}

	@Override
	public Pager getProcessingStagesPagerByPager(Pager pager) {
		String queryString = "FROM Stage s WHERE s.status = 1 OR s.status = 2 ORDER BY s.id DESC";
		List<Stage> datas = dao.find(queryString);
		List<Stage> pagerDatas = dao.find(queryString, (pager.getPageIndex()-1)*pager.getPageSize(), pager.getPageSize());
		pager.setTotalCount(datas.size());
		pager.init();
		pager.setDatas(pagerDatas);
		return pager;
	}

	@Override
	public void lotteryLuckyCode(Stage stage) {
		
	}
	
}
