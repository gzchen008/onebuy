package com.xianchumo.shop.controller.weixin;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vanroid.weixin.pojo.WeixinHolder;
import com.vanroid.weixin.pojo.WeixinOauth2Token;
import com.vanroid.weixin.pojo.WeixinUserInfo;
import com.vanroid.weixin.util.AdvancedUtil;
import com.xianchumo.shop.conf.ShopConfig;
import com.xianchumo.shop.entity.User;
import com.xianchumo.shop.service.RedPacketService;
import com.xianchumo.shop.service.UserService;
import com.xianchumo.shop.util.ShopUtil;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	public static Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private ShopConfig shopConfig;
	@Autowired
	private RedPacketService redPacketService;

	/**
	 * 用户注册方法
	 */
	@RequestMapping(value = "/register")
	public String register(User user) {
		userService.add(user);
		return "index";
	}

	@RequestMapping(value = "/weixinCallback")
	public void weixinCallback(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String code = request.getParameter("code");
		// 用户同意授权
		if (!"authdeny".equals(code)) {
			// 获取网页授权access_token
			WeixinOauth2Token weixinOauth2Token = AdvancedUtil.getOauth2AccessToken(shopConfig.getAppid(),
					shopConfig.getSecret(), code);
			// 网页授权接口访问凭证
			String accessToken = weixinOauth2Token.getAccessToken();
			// 用户标识
			String openId = weixinOauth2Token.getOpenId();
			logger.info("openId:" + openId);
			// 通过openId查找数据库，有内容则加载，无则为新注册
			User user = userService.getByOpenId(openId);
			if (user == null) {
				user = new User();
				user.setOpenid(openId);
				WeixinUserInfo userInfo = AdvancedUtil.getUserInfo(WeixinHolder.accessToken.getToken(), openId);
				logger.info("[debug]userInfo:" + userInfo);
				user.setName(userInfo.getNickname());
				// 初始化用户信息
				ShopUtil.initUser(user);
				userService.add(user);
			}
			session.setAttribute("user", user);

		}

		try {
			response.sendRedirect(request.getAttribute("rootPath") + "/good/product");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 登录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login(User user, HttpServletRequest request) {
		User logUser = userService.login(user);
		if (logUser == null) {
			// TODO 这里的User最终应该是微信中取得的，测试里免
			userService.add(user);
			logUser = user;
		}
		request.getSession().setAttribute("user", logUser);
		return "index";
	}

	/**
	 * 个人信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/selfInfo")
	public String selfInfo() {

		return "selfInfo";
	}

	/**
	 * 充值
	 */
	@RequestMapping(value = "/recharge")
	public String recharge() {
		return "index";
	}

	/**
	 * 修改个人信息
	 */
	@RequestMapping(value = "/modifyInfo")
	public String modifyInfo(User user) {
		userService.update(user);
		return "selfInfo";
	}

	/**
	 * 显示个人信息
	 * 
	 * @return
	 */
	@RequestMapping(value="/me")
	public String me(HttpSession session) {
		User user = (User) session.getAttribute("user");
		int redCount = redPacketService.countByUser(user);
		session.setAttribute("redCount", redCount);
		return "weixin/me";
	}

}
