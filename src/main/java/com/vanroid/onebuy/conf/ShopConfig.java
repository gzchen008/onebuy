package com.vanroid.onebuy.conf;

public class ShopConfig {
	private String appid;
	private String secret;
	/**
	 * 微信回调地址
	 */
	
	private String weixinCallbackUrl;
	private static String ORIGIN_WEIXIN_CALLBACK ="https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	/**
	 * 替换掉占位符
	 * @return
	 */
	public String getWeixinCallbackUrl() {
		return ORIGIN_WEIXIN_CALLBACK.replace("APPID", appid).replace("REDIRECT_URI", weixinCallbackUrl).replace("SCOPE", "snsapi_base");
	}
	public void setWeixinCallbackUrl(String weixinCallbackUrl) {
		this.weixinCallbackUrl = weixinCallbackUrl;
	}
	
	
	

}
