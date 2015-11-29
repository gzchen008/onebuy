package com.xianchumo.shop.util;
/**
 * 信息处理工具类
 * @Team xianchumo
 * @author yangtk
 * @Date 10月3日
 *
 */
public class InfoUtil {
	public static boolean isNull(Object... objs){
		for(Object obj : objs){
			if(obj == null || obj.equals("")){
				return true;
			}
		}
		return false;
	}
	
}
