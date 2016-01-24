package com.vanroid.onebuy.core.holder;

import java.util.ArrayList;
import java.util.List;

import com.vanroid.onebuy.core.cache.CacheHandler;
import com.vanroid.onebuy.entity.Stage;

/**
 * 
 * @company vanroid.com
 * @author cgz
 * @date 2016年1月23日
 * @version 1.0
 * @description stage缓存
 */
public class StageHolder implements CacheHandler<Stage> {
	private List<Stage> stages;

	public List<Stage> getStages() {
		return stages;
	}

	public void setStages(List<Stage> stages) {
		this.stages = stages;
	}

	@Override
	public Stage get(Long id) {
		if (stages == null)
			return null;
		for (Stage stage : stages) {
			if (stage.getId().equals(id)) {
				return stage;
			}
		}
		return null;
	}

	@Override
	public void add(Stage entity) {
		if (stages == null)
			stages = new ArrayList<Stage>();
		stages.add(entity);
	}

}
