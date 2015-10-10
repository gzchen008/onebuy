package com.xianchumo.shop.controller.weixin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xianchumo.shop.entity.Address;
import com.xianchumo.shop.entity.Order;
import com.xianchumo.shop.entity.User;
import com.xianchumo.shop.service.AddressService;

@Controller
@RequestMapping(value = "/address")
public class AddressController {
	@Autowired
	private AddressService addressService;

	/**
	 * 添加地址
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add")
	public String add() {
		Address address = new Address("广东省", "广州市", "天河区");
		addressService.add(address);
		return "index";
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
	 * 地址查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/find")
	public String delete() {
		return "index";
	}
}
