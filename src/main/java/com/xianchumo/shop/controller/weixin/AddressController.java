package com.xianchumo.shop.controller.weixin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xianchumo.shop.entity.Address;
import com.xianchumo.shop.entity.AddressBase;
import com.xianchumo.shop.entity.Order;
import com.xianchumo.shop.entity.User;
import com.xianchumo.shop.exception.ShopParameterExceptioin;
import com.xianchumo.shop.service.AddressBaseService;
import com.xianchumo.shop.service.AddressService;
import com.xianchumo.shop.util.JsonUtil;

@Controller
@RequestMapping(value = "/address")
public class AddressController {
	@Autowired
	private AddressService addressService;
	@Autowired
	private AddressBaseService addressBaseService;

	/**
	 * 添加地址页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add")
	public String add(HttpServletRequest httpRequest, HttpSession session) {
		// 找出广州的直接下级
		List<AddressBase> lsAb = addressBaseService.findChildByName("广州市");
		httpRequest.setAttribute("lsAb", lsAb);
		return "weixin/add-address";
	}
	/**
	 * 地址选择页面
	 * @return
	 */
	public String addressView(HttpSession session){
		User user = (User) session.getAttribute("user");
		//找出用户的历史地址
		List<Address> lsAddr = addressBaseService.findByUser(user);
		return "weixin/address-history";
	}

	/**
	 * 保存地址
	 * liveAreaId 生活区ID
	 * @return
	 */
	@RequestMapping(value = "/save")
	public String save(Long liveAreaId ,Address address, HttpServletRequest request, HttpSession session) {
		if(liveAreaId == null)
			throw new ShopParameterExceptioin("参数错误");
		User user = (User) session.getAttribute("user");
		address.setUser(user);
		addressService.add(address);
		request.setAttribute("address", address);
		request.setAttribute("liveAreaId", liveAreaId);
		
		return "weixin/chooseAdressPayment";
	}

	/**
	 * 列出所有地址
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list")
	public String list() {
		List<Address> ls = addressService.findAll();
		return "chooseAddress";
	}

	/**
	 * 选择地址
	 */
	@RequestMapping(value = "/chosAddr")
	public String chooseAddr(Address address, HttpSession session) {
		User user = (User) session.getAttribute("user");
		Order order = (Order) session.getAttribute("order");
		order.setAddress(address);

		return "";
	}

	/**
	 * 查询子地址 返加json 用于地址联动
	 * 
	 * @return
	 */
	@RequestMapping(value = "/findChildById")
	public void findChildById(Long pid, HttpServletResponse response) {
		List<AddressBase> abs = addressBaseService.findChild(pid);
		JsonUtil.outPut(response, abs);
	}
}
