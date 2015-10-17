package com.vanroid.weixin.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.vanroid.weixin.pojo.SNSUserInfo;
import com.vanroid.weixin.pojo.WeixinOauth2Token;
import com.vanroid.weixin.pojo.WeixinUserInfo;

import antlr.collections.List;

/**
 * 高级接口工具类
 * 
 * @author liufeng
 * @date 2013-11-9
 */
public class AdvancedUtil {

	private static Logger log = LoggerFactory.getLogger(AdvancedUtil.class);

	/**
	 * 组装文本客服消息
	 * 
	 * @param openId
	 *            消息发送对象
	 * @param content
	 *            文本消息内容
	 * @return
	 */
	public static String makeTextCustomMessage(String openId, String content) {
		// 对消息内容中的双引号进行转义
		content = content.replace("\"", "\\\"");
		String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"text\",\"text\":{\"content\":\"%s\"}}";
		return String.format(jsonMsg, openId, content);
	}

	/**
	 * 组装图片客服消息
	 * 
	 * @param openId
	 *            消息发送对象
	 * @param mediaId
	 *            媒体文件id
	 * @return
	 */
	public static String makeImageCustomMessage(String openId, String mediaId) {
		String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"image\",\"image\":{\"media_id\":\"%s\"}}";
		return String.format(jsonMsg, openId, mediaId);
	}

	/**
	 * 组装语音客服消息
	 * 
	 * @param openId
	 *            消息发送对象
	 * @param mediaId
	 *            媒体文件id
	 * @return
	 */
	public static String makeVoiceCustomMessage(String openId, String mediaId) {
		String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"voice\",\"voice\":{\"media_id\":\"%s\"}}";
		return String.format(jsonMsg, openId, mediaId);
	}

	/**
	 * 组装视频客服消息
	 * 
	 * @param openId
	 *            消息发送对象
	 * @param mediaId
	 *            媒体文件id
	 * @param thumbMediaId
	 *            视频消息缩略图的媒体id
	 * @return
	 */
	public static String makeVideoCustomMessage(String openId, String mediaId, String thumbMediaId) {
		String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"video\",\"video\":{\"media_id\":\"%s\",\"thumb_media_id\":\"%s\"}}";
		return String.format(jsonMsg, openId, mediaId, thumbMediaId);
	}

	/**
	 * 获取网页授权凭证
	 * 
	 * @param appId
	 *            公众账号的唯一标识
	 * @param appSecret
	 *            公众账号的密钥
	 * @param code
	 * @return WeixinAouth2Token
	 */
	public static WeixinOauth2Token getOauth2AccessToken(String appId, String appSecret, String code) {
		WeixinOauth2Token wat = null;
		// 拼接请求地址
		String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
		requestUrl = requestUrl.replace("APPID", appId);
		requestUrl = requestUrl.replace("SECRET", appSecret);
		requestUrl = requestUrl.replace("CODE", code);
		// 获取网页授权凭证
		JsonObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
		if (null != jsonObject) {
			try {
				wat = new WeixinOauth2Token();
				wat.setAccessToken(jsonObject.get("access_token").getAsString());
				wat.setExpiresIn(jsonObject.get("expires_in").getAsInt());
				wat.setRefreshToken(jsonObject.get("refresh_token").getAsString());
				wat.setOpenId(jsonObject.get("openid").getAsString());
				wat.setScope(jsonObject.get("scope").getAsString());
			} catch (Exception e) {
				wat = null;
				int errorCode = jsonObject.get("errcode").getAsInt();
				String errorMsg = jsonObject.get("errmsg").getAsString();
				log.error("获取网页授权凭证失败 errcode:" + errorCode + "errmsg:" + errorMsg);
			}
		}
		return wat;
	}

	/**
	 * 刷新网页授权凭证
	 * 
	 * @param appId
	 *            公众账号的唯一标识
	 * @param refreshToken
	 * @return WeixinAouth2Token
	 */
	public static WeixinOauth2Token refreshOauth2AccessToken(String appId, String refreshToken) {
		WeixinOauth2Token wat = null;
		// 拼接请求地址
		String requestUrl = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
		requestUrl = requestUrl.replace("APPID", appId);
		requestUrl = requestUrl.replace("REFRESH_TOKEN", refreshToken);
		// 刷新网页授权凭证
		JsonObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
		if (null != jsonObject) {
			try {
				wat = new WeixinOauth2Token();
				wat.setAccessToken(jsonObject.get("access_token").getAsString());
				wat.setExpiresIn(jsonObject.get("expires_in").getAsInt());
				wat.setRefreshToken(jsonObject.get("refresh_token").getAsString());
				wat.setOpenId(jsonObject.get("openid").getAsString());
				wat.setScope(jsonObject.get("scope").getAsString());
			} catch (Exception e) {
				wat = null;
				int errorCode = jsonObject.get("errcode").getAsInt();
				String errorMsg = jsonObject.get("errmsg").getAsString();
				log.error("刷新网页授权凭证失败 errcode:" + errorCode + "errmsg:" + errorMsg);
			}
		}
		return wat;
	}

	/**
	 * 通过网页授权获取用户信息
	 * 
	 * @param accessToken
	 *            网页授权接口调用凭证
	 * @param openId
	 *            用户标识
	 * @return SNSUserInfo
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static SNSUserInfo getSNSUserInfo(String accessToken, String openId) {
		SNSUserInfo snsUserInfo = null;
		// 拼接请求地址
		String requestUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
		// 通过网页授权获取用户信息
		JsonObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);

		if (null != jsonObject) {
			try {
				snsUserInfo = new SNSUserInfo();
				// 用户的标识
				snsUserInfo.setOpenId(jsonObject.get("openid").getAsString());
				// 昵称
				snsUserInfo.setNickname(jsonObject.get("nickname").getAsString());
				// 性别（1是男性，2是女性，0是未知）
				snsUserInfo.setSex(jsonObject.get("sex").getAsInt());
				// 用户所在国家
				snsUserInfo.setCountry(jsonObject.get("country").getAsString());
				// 用户所在省份
				snsUserInfo.setProvince(jsonObject.get("province").getAsString());
				// 用户所在城市
				snsUserInfo.setCity(jsonObject.get("city").getAsString());
				// 用户头像
				snsUserInfo.setHeadImgUrl(jsonObject.get("headimgurl").getAsString());
				// 用户特权信息
				/*
				 * Gson gson = new Gson(); List ls =
				 * gson.fromJson(jsonObject.get("privilege").getAsString(),List.
				 * class); snsUserInfo.setPrivilegeList(ls);
				 */
			} catch (Exception e) {
				snsUserInfo = null;
				int errorCode = jsonObject.get("errcode").getAsInt();
				String errorMsg = jsonObject.get("errmsg").getAsString();
				log.error("获取用户信息失败 errcode:" + errorCode + " errmsg:" + errorMsg);
			}
		}
		return snsUserInfo;
	}

	/**
	 * 下载媒体文件
	 * 
	 * @param accessToken
	 *            接口访问凭证
	 * @param mediaId
	 *            媒体文件标识
	 * @param savePath
	 *            文件在服务器上的存储路径
	 * @return
	 */
	// TODO 可以使用
	public static String getMedia(String accessToken, String mediaId, String savePath) {
		String filePath = null;
		String saveFileName = null;
		// 拼接请求地址
		String requestUrl = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("MEDIA_ID", mediaId);
		System.out.println(requestUrl);
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setRequestMethod("GET");

			if (!savePath.endsWith("/")) {
				savePath += "/";
			}
			// 根据内容类型获取扩展名
			String fileExt = CommonUtil.getFileExt(conn.getHeaderField("Content-Type"));
			// 将mediaId作为文件名
			filePath = savePath + mediaId + fileExt;
			// 返回路径
			saveFileName = mediaId + fileExt;
			BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
			FileOutputStream fos = new FileOutputStream(new File(filePath));
			byte[] buf = new byte[8096];
			int size = 0;
			while ((size = bis.read(buf)) != -1)
				fos.write(buf, 0, size);
			fos.close();
			bis.close();

			conn.disconnect();
			log.info("下载媒体文件成功，filePath=" + filePath);
		} catch (Exception e) {
			filePath = null;
			log.error("下载媒体文件失败：{}", e);
		}
		return saveFileName;
	}

	/**
	 * 获取用户信息
	 * 
	 * @param accessToken
	 *            接口访问凭证
	 * @param openId
	 *            用户标识
	 * @return WeixinUserInfo
	 */
	public static WeixinUserInfo getUserInfo(String accessToken, String openId) {
		WeixinUserInfo weixinUserInfo = null;
		// 拼接请求地址
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
		// 获取用户信息
		JsonObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);

		if (null != jsonObject) {
			try {
				weixinUserInfo = new WeixinUserInfo();
				// 用户的标识
				weixinUserInfo.setOpenId(jsonObject.get("openid").getAsString());
				// 关注状态（1是关注，0是未关注），未关注时获取不到其余信息
				weixinUserInfo.setSubscribe(jsonObject.get("subscribe").getAsInt());
				// 用户关注时间
				weixinUserInfo.setSubscribeTime(jsonObject.get("subscribe_time").getAsString());
				// 昵称
				weixinUserInfo.setNickname(jsonObject.get("nickname").getAsString());
				// 用户的性别（1是男性，2是女性，0是未知）
				weixinUserInfo.setSex(jsonObject.get("sex").getAsInt());
				// 用户所在国家
				weixinUserInfo.setCountry(jsonObject.get("country").getAsString());
				// 用户所在省份
				weixinUserInfo.setProvince(jsonObject.get("province").getAsString());
				// 用户所在城市
				weixinUserInfo.setCity(jsonObject.get("city").getAsString());
				// 用户的语言，简体中文为zh_CN
				weixinUserInfo.setLanguage(jsonObject.get("language").getAsString());
				// 用户头像
				weixinUserInfo.setHeadImgUrl(jsonObject.get("headimgurl").getAsString());
			} catch (Exception e) {
				if (0 == weixinUserInfo.getSubscribe()) {
					log.error("用户" + weixinUserInfo.getOpenId() + "已取消关注");
				} else {
					int errorCode = jsonObject.get("errcode").getAsInt();
					String errorMsg = jsonObject.get("errmsg").getAsString();
					log.error("获取用户信息失败 errcode:" + errorCode + " errmsg:" + errorMsg);
				}
			}
		}
		return weixinUserInfo;
	}

}
