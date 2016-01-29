package com.vanroid.onebuy.controller.admin;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vanroid.onebuy.common.Pager;
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
	 * 所有期数
	 * @param pager
	 * @param model
	 * @return
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
		model.addAttribute("title", "所有期数");
		return "admin/stage/latest_stage";
	}
	/**
	 * 所有期数 列表 （分页）
	 * @param pageIndex
	 * @param pager
	 * @param model
	 * @return
	 */
	@RequestMapping("/stages/latestto")
	public String latestStageListPager(@RequestParam("page") int pageIndex,Pager pager,Model model){
		if(pager.getTotalCount()==0){
			pager = new Pager();
			pager.setPageIndex(pageIndex);
			pager.setPageSize(4);
			
		}
		pager = stageService.findByPager(pager);
		model.addAttribute("pager",pager);
		model.addAttribute("title", "所有期数");
		return "admin/stage/latest_stage";
	}
	/**
	 * 正在进行的 期列表
	 * @param pager
	 * @param model
	 * @return
	 */
	@RequestMapping("/stages/processing")
	public String processingStages(Pager pager,Model model){
		if(pager.getTotalCount()==0){
			pager = new Pager();
			pager.setPageIndex(1);
			pager.setPageSize(4);
			
		}
		pager = stageService.getProcessingStagesPagerByPager(pager);
		model.addAttribute("pager", pager);
		model.addAttribute("title", "正在进行");
		return "admin/stage/latest_stage";
	}
	
	
	@RequestMapping("/stages/processingto")
	public String processingStagesPager(@RequestParam int page,Pager pager,Model model){
		if(pager.getTotalCount()==0){
			pager = new Pager();
			pager.setPageIndex(page);
			pager.setPageSize(4);
			
		}
		pager = stageService.getProcessingStagesPagerByPager(pager);
		model.addAttribute("pager", pager);
		model.addAttribute("title", "正在进行");
		return "admin/stage/latest_stage";
	}
	
	/**
	 * 期 详情
	 * @param stageId
	 * @param model
	 * @return
	 */
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
	
	/**
	 * 修改期
	 * @param stageId
	 * @param model
	 * @return
	 */
	@RequestMapping("/stages/edit/{stageId}")
	public String editStage(@PathVariable int stageId,Model model){
		Stage stage = stageService.get(stageId);
		model.addAttribute("stage", stage);
		return "admin/stage/edit_stage";
	}
	
	/**
	 * 更新 期
	 * @param stageId
	 * @param statusRadio
	 * @param deliveryRadio
	 * @return
	 */
	@RequestMapping("/stages/update/{stageId}")
	public String updateStageStatus(@PathVariable int stageId,
			@RequestParam int statusRadio,@RequestParam int deliveryRadio){
		Stage stage = stageService.get(stageId);
		stage.setStatus(statusRadio); //设置状态码
		stage.setIfDelivery(deliveryRadio); //设置是否发货
		stageService.update(stage);
		return "redirect:/admin/stages/detail/"+stageId;
	}
	
	/**
	 * 删除某期
	 * @param stageId
	 * @return
	 */
	@RequestMapping("/stages/delete/{stageId}")
	public String deleteProcessingStage(@PathVariable int stageId){
		Stage stage = stageService.get(stageId);
		stageService.delete(stage);
		
		return "redirect:/admin/stages/latest";
	}
	
	
}
