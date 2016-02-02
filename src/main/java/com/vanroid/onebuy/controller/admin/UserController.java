package com.vanroid.onebuy.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vanroid.onebuy.common.Pager;
import com.vanroid.onebuy.entity.User;
import com.vanroid.onebuy.service.UserService;

/**
*@author kaiscript
*@date 2016年2月1日 下午11:57:31
*/
@Controller
@RequestMapping("/admin")
public class UserController {
	
	@Resource(name = "userService")
	private UserService userService;
	
	@RequestMapping("/users")
	public String userIndex(Pager pager,Model model){
		if(pager.getTotalCount()==0){
			pager = new Pager();
			pager.setPageIndex(1);
			pager.setPageSize(4);
			
		}
		pager = userService.findByPager(pager);
		model.addAttribute("pager",pager);
		model.addAttribute("title", "所有用户");
		model.addAttribute("url", "/admin/usersto?page=");
		return "admin/user/user";
	}
	
	@RequestMapping(value ="/usersto",method=RequestMethod.GET)
	public String userIndexPager(@RequestParam("page") int pageIndex,Model model,Pager pager){

		if(pager.getTotalCount()==0){
			pager = new Pager();
			pager.setPageIndex(pageIndex);
			pager.setPageSize(4);
			
		}
		pager = userService.findByPager(pager);
		model.addAttribute("pager", pager);
		model.addAttribute("title", "用户管理");
		model.addAttribute("url", "/admin/usersto?page=");
		return "admin/user/user";
	}
	
	
	@RequestMapping("/users/detail/{userId}")
	public String userDetail(@PathVariable int userId,Model model){
		User user = userService.get(userId);
		model.addAttribute("user", user);
		return "admin/user/user_detail";
	}
	
	@RequestMapping("/users/delete/{userId}")
	public String deleteUser(@PathVariable int userId){
		User user = userService.get(userId);
		userService.delete(user);
		return "redirect:/admin/users";
	}
	
	@RequestMapping("/users/update/{userId}")
	public String deleteUser(@PathVariable int userId,String username,String password,
			String phone,String wxOpenid, Model model){
		User user = userService.get(userId);
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setWxOpenid(wxOpenid);
		userService.update(user);
		return "redirect:/admin/users";
	}
	
}
