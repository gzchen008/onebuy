package com.vanroid.onebuy.controller.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vanroid.onebuy.common.Pager;

/**
*@author kaiscript
*@date 2016年1月27日 下午11:33:23
*/
@Controller
@RequestMapping("/admin")
public class StageController {
	
	
	/*@RequestMapping("/stage/latest")
	public String latestStageList(Pager pager,Model model){
		if(pager.getTotalCount()==0){
			pager = new Pager();
			pager.setPageIndex(1);
			pager.setPageSize(4);
			
		}
		pager = latestStageService.findByPager(pager);
		List<LatestStage> latestStages = latestStageService.findAll();
		model.addAttribute("pager", pager);
		
		return "admin/stage/latest_stage";
	}*/
}
