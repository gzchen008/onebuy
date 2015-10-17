package com.xianchumo.shop.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * 
 * Copyright 2015 xianchumo.com
 * 
 * @Team xianchumo
 * @data：2015年10月5日 @author CGZ
 * @description
 */
public class ShopFilter extends CharacterEncodingFilter {
	private static Logger logger = LoggerFactory.getLogger(ShopFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// 获取根地址
		request.setAttribute("rootPath", getRootPath(request));
		super.doFilterInternal(request, response, filterChain);
	}

	private String getRootPath(HttpServletRequest request) {
		String rootPath = request.getContextPath();
		logger.info("uri:" + request.getRequestURI());
		Enumeration<String> pn = request.getParameterNames();
		while (pn.hasMoreElements()) {
			String name = pn.nextElement();
			logger.info("[debug params]" + name + ":" + request.getParameter(name));
		}
		return rootPath;
	}

}
