package com.vanroid.onebuy.controller.admin;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vanroid.onebuy.common.Pager;
import com.vanroid.onebuy.entity.Good;
import com.vanroid.onebuy.entity.Stage;
import com.vanroid.onebuy.service.GoodService;
import com.vanroid.onebuy.service.StageService;

/**
*@author kaiscript
*@date 2016年1月27日 下午11:33:23
*/
@Controller
@RequestMapping("/admin")
public class StageController {
	
	@Resource(name = "stageService")
	private StageService stageService;
	@Resource(name = "goodService")
	private GoodService goodService;
	/**
	 * 进行中 主页
	 */
	@RequestMapping("/stages/latest")
	public String latestStageList(Pager pager,Model model){
		if(pager.getTotalCount()==0){
			pager = new Pager();
			pager.setPageIndex(1);
			pager.setPageSize(4);
			
		}
		pager = stageService.findByPager(pager);
		model.addAttribute("pager",pager);
		return "admin/stage/latest_stage";
	}
	
	@RequestMapping("/stages/latestto")
	public String latestStageListPager(@RequestParam("page") int pageIndex,Pager pager,Model model){
		if(pager.getTotalCount()==0){
			pager = new Pager();
			pager.setPageIndex(pageIndex);
			pager.setPageSize(4);
			
		}
		pager = stageService.findByPager(pager);
		model.addAttribute("pager",pager);
		return "admin/stage/latest_stage";
	}
	
	
	@RequestMapping("/stages/detail/{stageId}")
	public String stageDetail(@PathVariable int stageId,Model model){
		Stage stage = stageService.get(stageId);
		Stage latestStage = stageService.getLastStageByGoodId(stage.getGood().getId());
		int lastStageNum = latestStage.getStatus(); //最新一期 状态码
		System.out.println(lastStageNum);
		model.addAttribute("stage", stage);
		if(lastStageNum==1){
			model.addAttribute("createStage", false);
		}
		else{
			model.addAttribute("createStage", true);
		}
		
		return "admin/stage/stage_detail";
	}
	
	@RequestMapping("/stages/delete/{stageId}")
	public String deleteProcessingStage(@PathVariable int stageId){
		Stage stage = stageService.get(stageId);
		stageService.delete(stage);
		
		return "redirect:/admin/stages/latest";
	}
	
	
	//text
	/*@RequestMapping("/stages")
	public String deleteProcessingStage(){
		Set<Stage> stages = goodService.get(6l).getStages();
		for(Stage s:stages){
			System.out.println(s.getCreateTime());
		}
		
		return "redirect:/admin/stages/latest";
	}*/
}
