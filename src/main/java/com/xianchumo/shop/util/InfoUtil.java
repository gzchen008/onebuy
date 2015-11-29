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
	/**
	 * 根据总数量和分页大小得到分页数量
	 * @param totalCount
	 * @param pageSize
	 * @return
	 */
	public static Long getPageCount(Long totalCount, int pageSize){
		Long count = totalCount/pageSize;
		if(totalCount%pageSize>0)count++;
		return count;
	}
}
