package com.xianchumo.shop.controller.weixin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xianchumo.shop.entity.User;
import com.xianchumo.shop.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * 用户注册方法
	 */
	@RequestMapping(value = "/register")
	public String register(User user) {
		userService.add(user);
		return "index";
	}

	@RequestMapping(value = "/weixinCallback")
	public String weixinCallback() {
		return "index";
	}

	/**
	 * 登录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login(User user,HttpServletRequest request) {
		User logUser = userService.login(user);
		if (logUser == null) {
			// TODO 这里的User最终应该是微信中取得的，测试里免
			userService.add(user);
			logUser = user;
		}
		request.getSession().setAttribute("user", logUser);
		return "index";
	}

	/**
	 * 个人信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/selfInfo")
	public String selfInfo() {
		
		return "selfInfo";
	}

	/**
	 * 充值
	 */
	@RequestMapping(value = "/recharge")
	public String recharge() {
		return "index";
	}

	/**
	 * 修改个人信息
	 */
	@RequestMapping(value = "/modifyInfo")
	public String modifyInfo(User user) {
		userService.update(user);
		return "selfInfo";
	}

}
