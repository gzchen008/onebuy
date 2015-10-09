package com.vanroid.weixin.pojo;
/**
 * JSAPI_TICKET
 * @author CGZ
 *
 */
public class JsApiTicket {
	private String ticket;
	private String expireIn;
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public String getExpireIn() {
		return expireIn;
	}
	public void setExpireIn(String expireIn) {
		this.expireIn = expireIn;
	}
	
}
