package com.vanroid.onebuy.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 
 * @company vanroid.com
 * @author cgz
 * @date 2016年3月5日
 * @version 1.0
 * @description Http存取值工具类
 */
public class RequestUtils {

	/**
	 * 获取session中的值
	 * 
	 * @param request
	 * @return
	 */
	public static Object getSessionAttr(HttpServletRequest request, String key) {
		HttpSession session = request.getSession();
		Object object = session.getAttribute(key);
		return object;
	}

	/**
	 * 往session存值
	 */
	public static void setSessionAttr(HttpServletRequest request, String key, Object value) {
		request.getSession().setAttribute(key, value);
	}

}
