package com.vanroid.onebuy.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.vanroid.onebuy.conf.ShopConfig;

public class LoginInterceptor implements HandlerInterceptor {
	private List<String> excludedUrls;

	private String loginUrl="/admin/login";
	
	@Autowired
	private ShopConfig shopConfig;
	private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("---afterCompletion---");
	}
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("---postHandle---");
	}
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
			Object arg2) throws Exception {
		System.out.println("---preHandle---");
		HttpSession session = req.getSession();
		String login =(String) session.getAttribute("login");
		System.out.println("login"+login);
		if(login==null || !login.equals("0")){
			resp.sendRedirect(req.getContextPath()+loginUrl);
			return false;
		}
		else 
			return true;
	}
	
}
