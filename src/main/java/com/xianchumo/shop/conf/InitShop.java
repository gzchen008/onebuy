package com.xianchumo.shop.conf;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vanroid.weixin.thread.TokenThread;

/**
 * 
 * Copyright 2015 xianchumo.com
 * @Team xianchumo
 * @data：2015年10月11日
 * @author CGZ
 * @description 初始化商城
 */
public class InitShop {
	private static Logger log = LoggerFactory.getLogger(InitShop.class);

	private TokenThread tokenThread;
	
	public InitShop(){
		init();
	}
	
	public void init(){
		log.info("init shop");
	}

	public TokenThread getTokenThread() {
		return tokenThread;
	}
	@Resource(name="tokenThread")
	public void setTokenThread(TokenThread tokenThread) {
		this.tokenThread = tokenThread;
		new Thread(tokenThread).start();
	}
	
	

}
