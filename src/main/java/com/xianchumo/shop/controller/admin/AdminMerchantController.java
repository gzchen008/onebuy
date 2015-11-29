package com.xianchumo.shop.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xianchumo.shop.entity.Merchant;
import com.xianchumo.shop.service.AdminService;
import com.xianchumo.shop.service.MerchantService;

/**
 * Merchant管理 Copyright 2015 xianchumo.com
 * 
 * @Team xianchumo
 * @data：2015年9月20日 @author yangtk
 * @description
 */
@Controller
@Scope("request")
@RequestMapping("/admin/merchant")
public class AdminMerchantController {
	@Autowired
	private MerchantService merchantService;
	@Autowired
	private AdminService adminService;
	/**
	 * 商家列表
	 */
	@RequestMapping(value = "/listMerchant")
	public String listMerchant(HttpServletRequest req,int page) {
		List<Merchant> merchants = merchantService.findMerchant(page);
		req.setAttribute("merchants", merchants);
		return "/admin/shopManage";
	}
	/**
	 * 跟据地址查看商家列表
	 */
	@RequestMapping(value = "/searchMerchant")
	public String searchMerchant(HttpServletRequest req,Long addressId, int page) {
		List<Merchant> merchants = merchantService.findByAddress(addressId, page);
		req.setAttribute("merchants", merchants);
		return "/admin/shopManage";
	}

	/**
	 * 商户详细信息
	 */
	@RequestMapping(value = "/merchantDetail")
	public String merchantDetail(Long merchantId, HttpServletRequest req) {
		req.setAttribute("merchant", merchantService.get(merchantId));
		return "/admin/merchantDetail";
	}

	/**
	 * 同意提现
	 */
	@RequestMapping(value = "/comfirmWithdraw")
	public String comfirmWithdraw() {
		return "index";
	}

}
