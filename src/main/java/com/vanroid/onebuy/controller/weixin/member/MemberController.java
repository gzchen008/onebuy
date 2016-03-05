package com.vanroid.onebuy.controller.weixin.member;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vanroid.onebuy.core.service.IndexCoreService;

/**
 * 
*  @company vanroid.com
 * @author cgz
 * @date 2016年3月5日
 * @version 1.0
 * @description 用户控制器
 */
@Controller
@RequestMapping("/member")
public class MemberController {
	@Resource(name = "indexCoreService")
	private IndexCoreService indexCoreService;

	@RequestMapping("/profile")
	public String profilePage(Model model) {
		return "weixin/member/profile";
	}



}