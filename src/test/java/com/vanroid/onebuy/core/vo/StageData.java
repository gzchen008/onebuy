package com.vanroid.onebuy.core.vo;

import java.util.List;

import com.vanroid.onebuy.entity.Stage;

/**
 * 
 * @company vanroid.com
 * @author cgz
 * @date 2016年3月6日
 * @version 1.0
 * @description
 */
public class StageData {

	private Long stageId;
	private Stage stage;
	private List<Integer> codes;

	public Long getStageId() {
		return stageId;
	}

	public void setStageId(Long stageId) {
		this.stageId = stageId;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public List<Integer> getCodes() {
		return codes;
	}

	public void setCodes(List<Integer> codes) {
		this.codes = codes;
	}

}
