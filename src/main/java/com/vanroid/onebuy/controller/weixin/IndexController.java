package com.vanroid.onebuy.controller.weixin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vanroid.onebuy.core.service.IndexCoreService;
import com.vanroid.onebuy.entity.CarouselAds;

/**
 * 
 * Copyright 2015 xianchumo.com
 * 
 * @Team xianchumo
 * @data：2015年9月20日 @author CGZ
 * @description 首页控制器
 */
@Controller
public class IndexController {
	@Resource(name="indexCoreService")
	private IndexCoreService indexCoreService; 
	@RequestMapping("/")
	public String indexPage(Model model) {
		//加载首页图片
		List<CarouselAds> carouselAdsList = indexCoreService.getCarouselAdsList();
		//即将揭晓
		
		//人气精选
		
		model.addAttribute("carouselAdsList", carouselAdsList);
		return "weixin/index";
	}

	@RequestMapping("freemarker")
	public String freemarker(Model model) {
		model.addAttribute("name", "cgz");
		return "weixin/test";
	}

}