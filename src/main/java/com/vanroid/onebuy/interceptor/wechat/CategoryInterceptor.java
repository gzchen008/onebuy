package com.vanroid.onebuy.interceptor.wechat;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.vanroid.onebuy.core.service.BizCoreService;
import com.vanroid.onebuy.entity.Category;

/**
 * 
*  @company vanroid.com
 * @author cgz
 * @date 2016年3月6日
 * @version 1.0
 * @description 分类拦截器
 */
public class CategoryInterceptor implements HandlerInterceptor {

	@Resource(name="bizCoreService")
	private BizCoreService bizCoreService;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//加载分类列表
		List<Category> categoryList = bizCoreService.getGoodCategoryList();
		request.setAttribute("categoryList", categoryList);
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

}
