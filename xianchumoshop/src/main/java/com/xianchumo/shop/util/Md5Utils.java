package com.xianchumo.shop.util;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class Md5Utils {
	private static Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
	/**
	 * 生成32位的MD5加密字符串
	 * @param str
	 * @return
	 */
	public static String md5(String str){
		//加密盐值 
		String salt = "xianchumo2015what";
		return md5PasswordEncoder.encodePassword(str, salt);

	}

}
