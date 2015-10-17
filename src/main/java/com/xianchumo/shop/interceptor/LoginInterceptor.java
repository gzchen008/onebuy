package com.xianchumo.shop.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.xianchumo.shop.conf.ShopConfig;
import com.xianchumo.shop.entity.User;
import com.xianchumo.shop.service.UserService;

public class LoginInterceptor implements HandlerInterceptor {
	private List<String> excludedUrls;
	@Autowired
	private UserService userService;
	@Autowired
	private ShopConfig shopConfig;
	private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();
		System.out.println(excludedUrls.size());
		for (String url : excludedUrls) {
			if (uri.endsWith(url)){
				System.out.println("fk");
				return true;
			}
		}
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {
			//TODO 真实情境，这里会跳转到微信认证
			//TODO 测试期间，直接取出用户
			/*User user = userService.get(1l);
			session.setAttribute("user", user);
			logger.info("使用了测试用户");*/
			
			response.sendRedirect(shopConfig.getWeixinCallbackUrl());
			return false;
		}
		return true;
	}
	
	

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

	public List<String> getExcludedUrls() {
		return excludedUrls;
	}

	public void setExcludedUrls(List<String> excludedUrls) {
		this.excludedUrls = excludedUrls;
	}

}
