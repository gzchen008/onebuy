package com.xianchumo.shop.controller.merchant;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xianchumo.shop.entity.Address;
import com.xianchumo.shop.entity.Merchant;
import com.xianchumo.shop.service.AddressService;
import com.xianchumo.shop.service.MerchantService;
import com.xianchumo.shop.util.Md5Utils;

/**
 * 
 * Copyright 2015 xianchumo.com
 * 
 * @Team xianchumo
 * @data：2015年9月25日 
 * @author yangtk
 * @description
 */
@Controller
@Scope("request")
@RequestMapping(value="/merchant")
@SessionAttributes("merchant")
public class MerchantController {
	private static final Logger logger = LoggerFactory.getLogger(MerchantController.class);
	@Autowired
	private MerchantService merchantService;
	@Autowired
	private AddressService addressService;
	/**
	 * 注册个人信息
	 */
	@RequestMapping(value = "/reg")
	public String register(String account, String password, String addressId){
		Address address = addressService.get(Long.parseLong(addressId));
		merchantService.createMerchant(account, Md5Utils.md5(password), address);
		return "/merchant/reg";
	}
	/**
	 * 登录
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("account") String account, 
			@RequestParam("password") String password, Model model) {
		Merchant merchant = merchantService.findByAccount(account);
		if(merchant != null){
			if(merchant.getPassword().equals(Md5Utils.md5(password))){
				model.addAttribute("merchant", merchant);
				return "/merchant/index";
			}
		}
		/*System.out.println("account");
		if(account.equals("111") && password.equals("222")){
			return "index";
		}*/
		return "/merchant/error";
	}

	/**
	 * 显示个人信息
	 */
	@RequestMapping(value = "/userInfo")
	public String userInfo() {
		
		return "/merchant/info";
	}

	/**
	 * 修改个人信息
	 */
	@RequestMapping(value = "/modifyUserInfo")
	public String modifyUserInfo() {
		return "/merchant/info";
	}

	/**
	 * 帐户信息
	 */
	@RequestMapping(value = "/accountInfo")
	public String accountInfo() {
		
		return "/merchant/account";
	}

	/**
	 * 申请提现
	 */
	@RequestMapping(value = "/applyWithdraw")
	public String applyWithdraw(@RequestParam double money, HttpSession session) {
		logger.debug("提现成功，已提款"+money+"元");
		Merchant merchant = (Merchant)session.getAttribute("merchant");
		merchant.subMoney(money);
		merchantService.update(merchant);
		return "/merchant/account";
	}

}
