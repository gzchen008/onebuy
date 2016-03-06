package com.vanroid.onebuy.service;

import com.vanroid.onebuy.entity.User;

/**
 * 
*  @company vanroid.com
 * @author cgz
 * @date 2016年1月17日
 * @version 1.0
 * @description TODO
 */
public interface UserService extends BaseService<User>{

	/**
	 * 通过openId ,加载用户实体
	 * @return
	 */
	public User getByOpenId(String openId);

}
