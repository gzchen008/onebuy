package com.vanroid.onebuy.controller.admin;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
			goodPager.setPageSize(4);
			
		}
		goodPager = goodService.findByPager(goodPager);
		model.addAttribute("goods", goodPager);
		return "admin/goods";
	}
}
