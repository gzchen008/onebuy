package com.vanroid.onebuy.core.holder;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @company vanroid.com
 * @author cgz
 * @date 2016年2月10日
 * @version 1.0
 * @description 全局緩存
 */
public class GlobalHolder {
	private Map<String, Object> values = new HashMap<String, Object>();

	
	/**
	 * 全局配置
	 */
	public static String GLOBAL_CONFIG = "global_config";

	public Object get(String key) {
		return values.get(key);
	}

	public Object set(String key, Object value) {
		return values.put(key, value);
	}

}
