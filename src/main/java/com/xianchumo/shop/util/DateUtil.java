package com.xianchumo.shop.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static DateUtil dateUtil;
	public static DateUtil getInstance(){
		if(dateUtil == null){
			dateUtil = new DateUtil();
		}
		return dateUtil;
	}
	private DateUtil(){}
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private DateFormat dbFormat = new SimpleDateFormat("yyyy-MM-dd");
	public String format(Date date) {
		return format.format(date);
	}
	public String dataBaseFormat(Date date){
		return dbFormat.format(date);
	}
}
