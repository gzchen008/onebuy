package com.vanroid.onebuy.interceptor.wechat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.vanroid.onebuy.core.common.BizConstant;
import com.vanroid.onebuy.entity.User;
import com.vanroid.onebuy.entity.UserDetail;
import com.vanroid.onebuy.util.RequestUtils;

/**
 * 
 * @company vanroid.com
 * @author cgz
 * @date 2016年3月5日
 * @version 1.0
 * @description 微信拦截器
 */
public class WechatInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user = (User) RequestUtils.getSessionAttr(request, BizConstant.REQUEST_USER_INFO);
		if (user == null) {
			// TODO 由于目前测试,不需要转至微信授权
			user = new User();
			user.setUsername("cgzjava");
			user.setWxOpenid("123456789abc");
			user.setId(1l);
			UserDetail userDetail = new UserDetail();
			user.setUserDetail(userDetail);

			RequestUtils.setSessionAttr(request, BizConstant.REQUEST_USER_INFO, user);
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

}
