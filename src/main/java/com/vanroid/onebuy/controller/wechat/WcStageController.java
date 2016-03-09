package com.vanroid.onebuy.controller.wechat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vanroid.onebuy.core.service.BizCoreService;
import com.vanroid.onebuy.entity.Stage;

/**
 * 
 * @company vanroid.com
 * @author cgz
 * @date 2016年3月5日
 * @version 1.0
 * @description 商品期 控制器
 */
@Controller
@RequestMapping("/stage")
public class WcStageController {
	@Resource(name = "bizCoreService")
	private BizCoreService bizCoreService;

	@RequestMapping("/newest")
	public String newestPage(HttpServletRequest request, Model model) {
		return "wechat/stage/newest";
	}

	/**
	 * 产品详情 应关联最新一期
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/product/{productId}/detail")
	public String stageProductDetailPage(@PathVariable Long productId, Model model) {
		Stage stage = bizCoreService.getStageDetailByProduct(productId);
		model.addAttribute("stage", stage);
		return "wechat/stage/stage_detail";
	}

}