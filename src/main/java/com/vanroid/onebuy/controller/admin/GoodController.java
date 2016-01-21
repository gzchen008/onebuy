package com.vanroid.onebuy.controller.admin;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vanroid.onebuy.common.Pager;
import com.vanroid.onebuy.service.GoodService;

/**
*@author kaiscript
*@date 2016年1月19日 下午9:54:51
*/
@Controller
@RequestMapping(value = "/admin")
public class GoodController {
	
	@Resource(name = "goodService")
	private GoodService goodService;

	@RequestMapping("/goods")  //使用分页
	public String goodIndex(Model model,Pager goodPager){
		if(goodPager.getTotalCount()==0){
			goodPager = new Pager();
			goodPager.setPageIndex(1);
			goodPager.setPageSize(1);
			
		}
		goodPager = goodService.findByPager(goodPager);
		model.addAttribute("pager", goodPager);
		return "admin/goods";
	}
	
	@RequestMapping(value ="/goods",method=RequestMethod.GET)
	public String goodIndexPager(@RequestParam("page") int pageIndex,Model model,Pager goodPager){
		if(goodPager.getTotalCount()==0){
			goodPager = new Pager();
			goodPager.setPageIndex(pageIndex);
			goodPager.setPageSize(1);
			
		}
		goodPager = goodService.findByPager(goodPager);
		model.addAttribute("pager", goodPager);
		return "admin/goods";
	}
	
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
