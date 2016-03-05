package com.vanroid.onebuy.interceptor.admin;

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
/**
 * 
*  @company vanroid.com
 * @author cgz
 * @date 2016年3月5日
 * @version 1.0
 * @description 后台访问控制器
 */
public class AdminLoginInterceptor implements HandlerInterceptor {
	private List<String> excludedUrls;

	private String loginUrl="/admin/login";
	
	private static Logger logger = LoggerFactory.getLogger(AdminLoginInterceptor.class);
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
			Object arg2) throws Exception {
		/*System.out.println("---preHandle---");
		HttpSession session = req.getSession();
		String login =(String) session.getAttribute("login");
		System.out.println("login"+login);
		if(login==null || !login.equals("0")){
			resp.sendRedirect(req.getContextPath()+loginUrl);
			return false;
		}
		else 
			return true;*/
		return true;
	}
	
}
