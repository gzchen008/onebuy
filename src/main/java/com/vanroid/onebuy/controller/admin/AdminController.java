package com.vanroid.onebuy.controller.admin;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("request")
@RequestMapping(value = "/admin")
public class AdminController {
	@RequestMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("name", "hello");
		return "admin/index";
	}
	
	
	
}
