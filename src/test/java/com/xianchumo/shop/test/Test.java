package com.xianchumo.shop.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args){
		/*DateFormat df = new SimpleDateFormat("yyyy年 MM月dd日");
		System.out.println(df.format(new Date()));*/
		try{
			test();
		}catch(RuntimeException e){
			System.out.println("runtimeException");
		}
		System.out.println("end");
	}
	public static void test()throws RuntimeException{
		try{
			System.out.println("test");
			throw new RuntimeException();
		}catch(Exception ex){
			System.out.println("exception");
		}
	}
}