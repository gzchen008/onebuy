package com.vanroid.onebuy.controller.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vanroid.onebuy.common.Pager;
import com.vanroid.onebuy.entity.Order;
import com.vanroid.onebuy.entity.Stage;
import com.vanroid.onebuy.service.OrderService;

/**
*@author kaiscript
*@date 2016年2月1日 下午10:27:19
*/
@Controller
@RequestMapping("/admin")
public class OrderController {
	
	@Resource(name = "orderService")
	private OrderService orderService;
	
	@RequestMapping("/orders")
	public String orderIndex(Pager pager,Model model){
		List<Order> orders = orderService.findAll();
		if(pager.getTotalCount()==0){
			pager = new Pager();
			pager.setPageIndex(1);
			pager.setPageSize(4);
			
		}
		pager = orderService.findByPager(pager);
		model.addAttribute("pager",pager);
		model.addAttribute("title", "订单管理");
		model.addAttribute("url", "/admin/ordersto?page=");
		model.addAttribute("pager", pager);
		return "admin/order/order";
	}
	
	
	@RequestMapping("/ordersto")
	public String orderListPager(@RequestParam("page") int pageIndex,Pager pager,Model model){
		if(pager.getTotalCount()==0){
			pager = new Pager();
			pager.setPageIndex(pageIndex);
			pager.setPageSize(4);
			
		}
		pager = orderService.findByPager(pager);
		model.addAttribute("pager",pager);
		model.addAttribute("title", "订单管理");
		model.addAttribute("url", "/admin/ordersto?page=");
		return "admin/order/order";
	}
	
	
	@RequestMapping("/orders/delete/{orderId}")
	public String deleteProcessingStage(@PathVariable int orderId){
		Order order = orderService.get(orderId);
		orderService.delete(order);
		
		return "redirect:/admin/orders";
	}
}
