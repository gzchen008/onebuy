package com.vanroid.onebuy.controller.wechat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vanroid.onebuy.core.common.BizConstant;
import com.vanroid.onebuy.core.service.IndexCoreService;
import com.vanroid.onebuy.entity.User;
import com.vanroid.onebuy.util.RequestUtils;

/**
 * 
 * @company vanroid.com
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
	public String profilePage(HttpServletRequest request, Model model) {
		User user = (User) RequestUtils.getSessionAttr(request, BizConstant.REQUEST_USER_INFO);
		model.addAttribute("user", user);
		return "wechat/member/profile";
	}

}