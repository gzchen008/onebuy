package com.xianchumo.shop.controller.merchant;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xianchumo.shop.entity.Address;
import com.xianchumo.shop.entity.AddressBase;
import com.xianchumo.shop.entity.Merchant;
import com.xianchumo.shop.exception.ShopException;
import com.xianchumo.shop.service.AddressBaseService;
import com.xianchumo.shop.service.AddressService;
import com.xianchumo.shop.service.MerchantService;
import com.xianchumo.shop.util.InfoUtil;
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
	@Autowired
	private AddressBaseService addressBaseService;
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
	public String login(String account, String password, HttpSession session) {
		Merchant merchant = merchantService.findByAccount(account);
		if(merchant != null){
			if(merchant.getPassword().equals(Md5Utils.md5(password))){
				session.setAttribute("merchant", merchant);
				return "redirect:/merchant/order/orderManage?page=1";
			}
		}
		/*System.out.println("account");
		if(account.equals("111") && password.equals("222")){
			return "index";
		}*/
		return "/merchant/error";
	}
	/**
	 * 注销登录
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/logout")
	public String logout(HttpSession session){
		Merchant merchant = (Merchant)session.getAttribute("merchant");
		if(merchant == null){
			return "/views/merchant/error";
		}
		session.removeAttribute("merchant");
		return "/views/merchant/login";
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
	public String modifyUserInfo(HttpSession session, String oldPassword, 
			String newPassword, String confirmPW){
		Merchant merchant = (Merchant)session.getAttribute("merchant");
		if(InfoUtil.isNull(oldPassword, newPassword, confirmPW)){
			throw new ShopException("信息不完整！");
		}
		if(!Md5Utils.md5(oldPassword).equals(merchant.getPassword())){
			throw new ShopException("账号密码错误");
		}
		if(!newPassword.equals(confirmPW)){
			throw new ShopException("两次密码输入");
		}
		merchant.setPassword(Md5Utils.md5(newPassword));
		merchantService.update(merchant);
		return "/merchant/info";
	}
	/**
	 * 修改地址
	 */
	@RequestMapping(value = "/modifyAddress")
	public String accountAddress(Long addressId, HttpSession session) {
		Merchant merchant = (Merchant)session.getAttribute("merchant");
		if(merchant == null){
			throw new ShopException("登陆超时，请重新登陆！");
		}
		AddressBase address = addressBaseService.get(addressId);
		merchant.setAddressBase(address);
		merchantService.update(merchant);
		session.getAttribute("merchant");
		return "/merchant/account";
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
	public String applyWithdraw(double money, HttpSession session) {
		logger.debug("提现成功，已提款"+money+"元");
		Merchant merchant = (Merchant)session.getAttribute("merchant");
		if(money>merchant.getOverage()){
			throw new ShopException("余额不足");
		}
		merchant.subMoney(money);
		merchantService.update(merchant);
		return "/merchant/account";
	}
	
}
