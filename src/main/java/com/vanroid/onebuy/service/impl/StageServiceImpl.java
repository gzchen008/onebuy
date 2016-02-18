package com.vanroid.onebuy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.vanroid.onebuy.common.Pager;
import com.vanroid.onebuy.dao.BaseDao;
import com.vanroid.onebuy.dao.GoodDao;
import com.vanroid.onebuy.entity.Good;
import com.vanroid.onebuy.entity.Stage;
import com.vanroid.onebuy.service.StageService;

/**
 * @author kaiscript
 * @date 2016年1月22日 下午6:09:13
 */
@Service("stageService")
public class StageServiceImpl extends BaseServiceImpl<Stage> implements StageService {
	
	private GoodDao goodDao;
	
	@Override
	@Resource(name = "stageDao")
	public void setDao(BaseDao<Stage> dao) {
		super.setDao(dao);
	}
	
	@Resource(name = "goodDao")
	public void setGoodDao(BaseDao<Good> dao){
		this.goodDao = (GoodDao) dao;
	}
	
	@Override
	public Integer getLastStageNum(Long goodId) {
		String queryString = "SELECT stage.num FROM Stage stage WHERE stage.good.id = ? ORDER BY stage.id DESC";
		return dao.findFirst(queryString, goodId);
	}

	@Override
	public Stage getLastStageByGoodId(Long goodId) {
		String queryString = "FROM Stage s WHERE s.good.id = ? ORDER BY s.id DESC";
		List<Stage> stage = dao.find(queryString, goodId);
		if(stage.size()==0)
			return null;
		else
			return stage.get(0);
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
	public Pager getStagesFuzzyPagerByPager(String goodName,Pager pager) {
		String queryString = "FROM Good g WHERE g.name like :name";
		List<Good> goods = goodDao.find(queryString, "name", "%"+goodName+"%");
		if(goods.size()!=0){
			List<Stage> stages = findStages(goods,pager);
			pager.setTotalCount(stages.size());
			pager.init();
			pager.setDatas(stages);
			return pager;
		}
		
		return null;
	}
	
	@Override
	public Pager getProcessingStagesFuzzyPagerByPager(String goodName, Pager pager) {
		String queryString = "FROM Good g WHERE g.name like :name";
		List<Good> goods = goodDao.find(queryString, "name", "%"+goodName+"%");
		if(goods.size()!=0){
			List<Stage> stages = findProcessingStages(goods,pager);
			pager.setTotalCount(stages.size());
			pager.init();
			pager.setDatas(stages);
			return pager;
		}
		return null;
	}
	
	/**
	 * 根据商品名找出对应 所有进行中的期数
	 * @param goods
	 * @return
	 */
	private List<Stage> findProcessingStages(List<Good> goods,Pager pager){
		String queryString = "FROM Stage s WHERE s.status in ('1','2') AND s.good.name in";
		String names = "(";
		for(int i = 0;i<goods.size();i++){
			System.out.println(goods.get(i).getName());
			if(i!=goods.size()-1){
				names = names +  "'"+goods.get(i).getName()+"'"+",";
			}
			else{
				names = names +  "'"+goods.get(i).getName()+"'"+")";
			}
		}
		queryString = queryString + names;
		List<Stage> stages =dao.find(queryString,(pager.getPageIndex()-1)*pager.getPageSize(),pager.getPageSize());
		return stages;
	}
	
	/**
	 * 根据商品名找出对应 所有期数
	 * @param goods
	 * @return
	 */
	private List<Stage> findStages(List<Good> goods,Pager pager){
		String queryString = "FROM Stage s where s.good.name in";
		String names = "(";
		for(int i = 0;i<goods.size();i++){
			if(i!=goods.size()-1){
				names = names +  "'"+goods.get(i).getName()+"'"+",";
			}
			else{
				names = names +  "'"+goods.get(i).getName()+"'"+")";
			}
		}
		queryString = queryString + names;
		List<Stage> stages =dao.find(queryString,(pager.getPageIndex()-1)*pager.getPageSize(),pager.getPageSize());
		return stages;
	}

	
}
