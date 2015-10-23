package com.xianchumo.shop.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xianchumo.shop.interceptor.LoginInterceptor;

/**
 * Json工具类
 * @author CGZ
 *
 */
public class JsonUtil {
	private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);
	/**
	 * 向网页输出Json
	 * @param response
	 * @param obj
	 */
	public static void outPut(HttpServletResponse response,Object obj){
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		logger.info("[debug]jsonStr:"+json);
		response.setContentType("application/json;charset=utf-8");
		try {
			response.getWriter().print(json);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
