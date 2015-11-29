package com.xianchumo.shop.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Json工具类
 * @author CGZ
 *
 */
public class JsonUtil {
	private static Gson  gson = new Gson();
	/**
	 * 向网页输出Json
	 * @param response
	 * @param obj
	 */
	public static void outPut(HttpServletResponse response,Object obj){
		
		String json = gson.toJson(obj);
		response.setContentType("application/json");
		try {
			response.getWriter().print(json);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String toString(Object obj){
		return gson.toJson(obj);
	}

}
