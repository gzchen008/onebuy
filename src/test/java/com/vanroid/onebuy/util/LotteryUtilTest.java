package com.vanroid.onebuy.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

/**
*@author kaiscript
*@date 2016年1月30日 下午12:03:43
*/
public class LotteryUtilTest {
	
	@Test
	public void codeTest(){
		String[] codes = LotteryUtil.getAllCodeByQuantity(20);
		System.out.println("---all codes----");
		for(String c:codes){
			System.out.println(c+" ");
		}
		Date date = new Date();
		List<Date> dates = new ArrayList<Date>();
		dates.add(date);
		System.out.println("---lucky code---");
		System.out.println(LotteryUtil.getLuckyCode(dates, 20));
		
	}
}
