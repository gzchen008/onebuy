package com.vanroid.onebuy.controller.wechat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
public class WcMemberController {
	@Resource(name = "indexCoreService")
	private IndexCoreService indexCoreService;

	@RequestMapping("/profile")
	public String profilePage(HttpServletRequest request, Model model) {
		User user = (User) RequestUtils.getSessionAttr(request, BizConstant.REQUEST_USER_INFO);
		model.addAttribute("user", user);
		return "wechat/member/profile";
	}

	@RequestMapping("/cart")
	public String cartPage(HttpServletRequest request, Model model) {
		return "wechat/member/cart";
	}
	
	@RequestMapping(value="/profile/edit",method=RequestMethod.GET)
	public String profileEditPage(HttpServletRequest request, Model model){
		User user = (User) RequestUtils.getSessionAttr(request, BizConstant.REQUEST_USER_INFO);
		model.addAttribute("user", user);
		return "wechat/member/profile_edit";
	}
	
	@RequestMapping(value="/profile/edit",method=RequestMethod.POST)
	public String updatePprofileEdit(){
		return "wechat/member/profile_edit";
	}
}