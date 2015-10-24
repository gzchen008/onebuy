package com.xianchumo.shop.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xianchumo.shop.entity.Admin;
import com.xianchumo.shop.exception.ShopException;
import com.xianchumo.shop.service.AdminService;
import com.xianchumo.shop.util.InfoUtil;
import com.xianchumo.shop.util.Md5Utils;
@Controller
@Scope("request")
@RequestMapping(value="/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	/**
	 * 登录
	 */
	@RequestMapping(value = "/login")
	public String login(String account, String password, HttpSession session) {
		if(InfoUtil.isNull(account, password)){
			throw new ShopException("信息不完整!");
		}
		Admin admin = adminService.findByAccount(account);
		if(admin == null 
		||!admin.getPassword().equals(Md5Utils.md5(password))){
			throw new ShopException("用户不存在或密码错误");
		}
		session.setAttribute("admin", admin);
		return "/views/index";
	}

	/**
	 * 退出
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("admin");
		return "/views/login";
	}

	/**
	 * 修改密码
	 */
	@RequestMapping(value = "/modifyPassword")
	public String modifyPassword(String oldPassword,
			String newPassword, String confirmPW, HttpSession session) {
		if(InfoUtil.isNull(oldPassword, newPassword, confirmPW)
		|| !newPassword.equals(confirmPW)){
			throw new ShopException("信息不完整或两次密码不相同！");
		}
		Admin admin = (Admin)session.getAttribute("admin");
		if(admin == null){
			throw new ShopException("登录超时，请重新登录！");
		}
		if(admin.getPassword().equals(Md5Utils.md5(oldPassword))){
			throw new ShopException("密码错误！");
		}
		admin.setPassword(Md5Utils.md5(newPassword));
		adminService.update(admin);
		session.setAttribute("admin", admin);
		return "index";
	}
	/**
	 * 更改密码
	 */
	@RequestMapping(value = "/changePassword")
	public String modifyPassword(String account, String newPassword) {
		if(InfoUtil.isNull(account, newPassword)){
			throw new ShopException("信息不完整！");
		}
		Admin admin = adminService.findByAccount(account);
		admin.setPassword(Md5Utils.md5(newPassword));
		adminService.update(admin);
		return "/views/admin/changePassword";
	}
}
