package com.vanroid.weixin.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vanroid.weixin.pojo.AccessToken;
import com.vanroid.weixin.pojo.JsApiTicket;
import com.vanroid.weixin.pojo.WeixinHolder;
import com.vanroid.weixin.util.WeixinUtil;

/**
 * 
 * Copyright 2015 xianchumo.com
 * @Team xianchumo
 * @data：2015年10月7日
 * @author CGZ
 * @description 定时获取微信access_token的线程
 */
public class TokenThread implements Runnable {
	Logger log = LoggerFactory.getLogger(TokenThread.class);
	// 第三方用户唯一凭证
	public static String appid = WeixinHolder.appid;
	// 第三方用户唯一凭证密钥
	public static String appsecret = WeixinHolder.secret;
	public static AccessToken accessToken = null;
	public static JsApiTicket jsApiTicket;

	public void run() {
		while (true) {
			try {
				accessToken = WeixinUtil.getAccessToken(appid, appsecret);
				if (null != accessToken) {
					log.info(
							"获取access_token成功，有效时长" + accessToken.getExpiresIn() + "秒 token:" + accessToken.getToken());
					// 获取 jsapi_ticket
					jsApiTicket = WeixinUtil.getJsApiTicket(accessToken.getToken());
					// 记录交数
					int jsatCount = 0;
					while (jsApiTicket == null) {
						System.out.println("再来一次！");
						jsApiTicket = WeixinUtil.getJsApiTicket(accessToken.getToken());
						jsatCount++;
						// 休眠10s
						Thread.sleep(10 * 1000);
					}
					// 存入全局中
					WeixinHolder.accessToken = accessToken;
					WeixinHolder.jsApiTicket = jsApiTicket;
					log.info(
							"获取jsapi_ticket成功，有效时长" + jsApiTicket.getExpireIn() + "秒，ticket" + jsApiTicket.getTicket());

					// 休眠7000秒
					Thread.sleep((accessToken.getExpiresIn() - 1000) * 1000);
				} else {
					// 如果access_token为null，60秒后再获取
					Thread.sleep(60 * 1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				try {
					Thread.sleep(60 * 1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
