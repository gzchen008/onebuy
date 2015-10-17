package com.vanroid.weixin.thread;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vanroid.weixin.pojo.AccessToken;
import com.vanroid.weixin.pojo.JsApiTicket;
import com.vanroid.weixin.pojo.WeixinHolder;
import com.vanroid.weixin.util.WeixinUtil;
import com.xianchumo.shop.conf.ShopConfig;

/**
 * 
 * Copyright 2015 xianchumo.com
 * 
 * @Team xianchumo
 * @data：2015年10月7日 @author CGZ
 * @description 定时获取微信access_token的线程
 */
public class TokenThread implements Runnable {
	Logger log = LoggerFactory.getLogger(TokenThread.class);
	@Autowired
	private ShopConfig shopConfig;
	@Override
	public void run() {
		while (true) {
			try {
				log.info("tokenthread run");
				AccessToken accessToken = WeixinUtil.getAccessToken(shopConfig.getAppid(), shopConfig.getSecret());
				
				if (null != accessToken) {
					log.info(
							"获取access_token成功，有效时长" + accessToken.getExpiresIn() + "秒 token:" + accessToken.getToken());
					WeixinHolder.accessToken = accessToken;
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
