package com.vanroid.onebuy.controller.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vanroid.onebuy.entity.Admin;
import com.vanroid.onebuy.service.AdminService;

import net.sf.json.JSONObject;

@Controller
@Scope("request")
public class AdminController {
	
	@Resource(name = "adminService")
	private AdminService adminService;
	
	@RequestMapping(value = "/admin")
	public String index(Model model) {
		model.addAttribute("name", "hello");
		return "admin/index";
	}
	
	@RequestMapping(value = "/admin/login")
	public String adminLogin(){
		return "admin/login";
	}
	
	@RequestMapping("/admin/edit")
	public String editAdmin(Model model){
		Admin admin = adminService.findAll().get(0);
		model.addAttribute("admin", admin);
		return "admin/edit_admin_info";
	}
	
	@RequestMapping("/admin/update/{adminId}")
	public String updateAdmin(@PathVariable int adminId,String name,String password){
		Admin admin = adminService.get(adminId);
		admin.setName(name);
		admin.setPassword(password);
		adminService.update(admin);
		return "redirect:/admin/edit";
	}
	
	@RequestMapping("/validate/check")
	@ResponseBody
	public JSONObject checkAdmin(@RequestParam String name,@RequestParam String password,HttpServletRequest req){
		JSONObject json = new JSONObject();
		Admin admin = adminService.getAdminByName(name);
		if(admin!=null){
			if(admin.getPassword().equals(password)){
				req.getSession().setAttribute("login", "0");
				json.put("code", "0");
				json.put("message", "success");
				return json;
			}
			else{
				json.put("code", "1");
				json.put("message", "fail");
				req.getSession().setAttribute("login", "1");
			}
		}
		else{
			json.put("code", "1");
			json.put("message", "fail");
			req.getSession().setAttribute("login", "1");
		}
		return json;

	} 
	
	@RequestMapping("/valicate/logout")
	public String logout(HttpServletRequest req){
		req.getSession().setAttribute("login", "1");
		System.out.println(req.getSession().getAttribute("login"));
		return "redirect:/admin/login";
	}
	
}
