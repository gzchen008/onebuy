package com.vanroid.onebuy.controller.admin;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vanroid.onebuy.common.Pager;
import com.vanroid.onebuy.entity.Good;
import com.vanroid.onebuy.entity.LatestStage;
import com.vanroid.onebuy.entity.Stage;
import com.vanroid.onebuy.service.GoodService;
import com.vanroid.onebuy.service.StageService;

/**
*@author kaiscript
*@date 2016年1月19日 下午9:54:51
*/
@Controller
@RequestMapping(value = "/admin")
public class GoodController {
	
	@Resource(name = "goodService")
	private GoodService goodService;
	
	@Resource(name = "stageService")
	private StageService stageService;
	
	@RequestMapping(value = "/goods",method=RequestMethod.GET)
	public String goodIndex(Model model,Pager goodPager){
		if(goodPager.getTotalCount()==0){
			goodPager = new Pager();
			goodPager.setPageIndex(1);
			goodPager.setPageSize(2);
			
		}
		goodPager = goodService.findByPager(goodPager);
		model.addAttribute("pager", goodPager);
		return "admin/good/goods";
	}
	
	@RequestMapping(value ="/goods",method=RequestMethod.POST)
	public String goodIndexPager(@RequestParam("page") int pageIndex,Model model,Pager goodPager){
		if(goodPager.getTotalCount()==0){
			goodPager = new Pager();
			goodPager.setPageIndex(pageIndex);
			goodPager.setPageSize(1);
			
		}
		goodPager = goodService.findByPager(goodPager);
		model.addAttribute("pager", goodPager);
		return "admin/goods/goods";
	}
	
	@RequestMapping("/goods/detail/{goodId}")
	public String goodDetail(@PathVariable int goodId,Model model){
		Good good = goodService.get(goodId);
		Set<Stage> stages = good.getStages();
		LatestStage latestStage = good.getLatestStage();
		int i=0;
		if(stages!=null && latestStage!=null){
			model.addAttribute("stages", stages);
			model.addAttribute("latestStage", latestStage);
		}
		if(good!=null){
			model.addAttribute("good", good);
		}
		
		return "admin/good/good_detail";
	}
	
	
	//test
	@RequestMapping(value ="/pager",method=RequestMethod.GET)
	public String goodTextPager(@RequestParam("page") int pageIndex,Model model,Pager goodPager){
		if(goodPager.getTotalCount()==0){
			goodPager = new Pager();
			goodPager.setPageIndex(pageIndex);
			goodPager.setPageSize(1);
			
		}
		goodPager = goodService.findByPager(goodPager);
		model.addAttribute("pager", goodPager);
		return "admin/test/pagerTest";
	}
	
}
