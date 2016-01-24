
package com.vanroid.onebuy.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static DateUtil dateUtil;
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private DateFormat dbFormat = new SimpleDateFormat("yyyy-MM-dd");

	private DateUtil() {
	}

	public static DateUtil getInstance() {
		if (dateUtil == null) {
			dateUtil = new DateUtil();
		}
		return dateUtil;
	}

	public String format(Date date) {
		return format.format(date);
	}

	public String dataBaseFormat(Date date) {
		return dbFormat.format(date);
	}

	/**
	 * 获取当前日期
	 * 
	 * @return
	 */
	public static Date getDate() {
		return new Date();
	}
}
