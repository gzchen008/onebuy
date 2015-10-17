package com.vanroid.weixin.util;

import java.net.URLEncoder;

/**
 * 
 * @author CGZ
 *
 */
public class WeixinUrlUtil {
	private static final String getTokenByCodeUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
	private static final String oauth2Url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URL&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect";
	public static String getAccessTokenUrlByCode(String appid,String secret,String code ){
		return getTokenByCodeUrl.replace("APPID", appid).replace("SECRET", secret).replace("CODE", code);
	}
	public static String getOauth2Url(String appid,String redirect_uri){
		redirect_uri = URLEncoder.encode(redirect_uri);
		return oauth2Url.replace("APPID", appid).replace("REDIRECT_URL", redirect_uri);
	}
	
}
