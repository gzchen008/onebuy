package com.vanroid.onebuy.util;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
*@author kaiscript
*@date 2016年1月30日 上午11:49:14
*@description 生成代码及抽奖工具类
*/
public class LotteryUtil {
	/**
	 * 根据份数 获得所有乱序代码
	 * @description index排序，value乱序
	 * @param quantity 份数
	 * @return
	 */
	public static String[] getAllCodeByQuantity(int quantity){
		int[] values = new int[quantity];
		String[] codes = new String[quantity];
		int temp1,temp2,temp3;
		Random random = new Random();
		for(int i=0;i<values.length;i++){
			values[i] = i;
		}
		for(int i=0;i<values.length;i++){
			temp1 = Math.abs(random.nextInt(quantity-1));//随机产生一个位置   
			temp2 = Math.abs(random.nextInt(quantity-1));//随机产生另一个位置   
			if(temp1!=temp2){
				temp3 = values[temp1];
				values[temp1] = values[temp2];
				values[temp2] = temp3;
			}
		}
		//再把最后一个数换一次,在前面的for中最后一个数很小概率会被抽中
		temp1 = Math.abs(random.nextInt()) % (values.length-1); //随机产生一个位置   
        
        if(temp1 != values.length-1){
            temp3 = values[temp1];   
            values[temp1] = values[values.length-1];   
            values[values.length-1] = temp3;
        } 
        
        for(int i=0;i<codes.length;i++){
        	codes[i] = String.valueOf(values[i]+10001);
        }
        return codes;
	}
	
	
	/**
	 * 获取 幸运码
	 * @param dates Date日期List
	 * @param quantity 份数
	 * @return
	 */
	public static String getLuckyCode(List<Date> dates,int quantity){
		Calendar cal = Calendar.getInstance();
		long sum=0;
		int luckyCode;
		for(Date date:dates){
			cal.setTime(date);
			sum+=getCalSum(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),
					cal.get(Calendar.DAY_OF_MONTH),cal.get(Calendar.HOUR_OF_DAY),
					cal.get(Calendar.MINUTE),cal.get(Calendar.SECOND));
		}
		sum+=System.currentTimeMillis();
		luckyCode = (int) (sum % quantity+10001);
		return String.valueOf(luckyCode);
	}
	
	/**
	 * 获取某个日期的值
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param minute
	 * @param second
	 * @return
	 */
	private static long getCalSum(int year,int month,int day,int hour,int minute,int second){
		long sum=0;
		sum+= year*Math.pow(10, 10)+(month+1)*Math.pow(10, 8)
				+day*Math.pow(10, 6)+hour*10000+minute*100+second;
		return sum; 
	}
}
