package com.vanroid.onebuy.controller.wechat;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vanroid.onebuy.core.service.IndexCoreService;
import com.vanroid.onebuy.entity.CarouselAds;
import com.vanroid.onebuy.entity.Good;
import com.vanroid.onebuy.entity.Stage;

/**
 * 
*  @company vanroid.com
 * @author cgz
 * @date 2016年3月5日
 * @version 1.0
 * @description TODO
 */
@Controller
public class IndexController {
	@Resource(name = "indexCoreService")
	private IndexCoreService indexCoreService;

	@RequestMapping("/")
	public String indexPage(Model model) {
		// 加载首页图片
		List<CarouselAds> carouselAdsList = indexCoreService.getCarouselAdsList();
		// 最新上架
		List<Good> newGoodList = indexCoreService.getNewGoodList(3);
		// 人气精选
		List<Stage> recommendStageList = indexCoreService.getRecommendStageList(0);

		model.addAttribute("carouselAdsList", carouselAdsList);
		model.addAttribute("recommendStageList", recommendStageList);
		model.addAttribute("newGoodList", newGoodList);
		return "weixin/index";
	}

	@RequestMapping("freemarker")
	public String freemarker(Model model) {
		model.addAttribute("name", "cgz");
		return "weixin/test";
	}

}