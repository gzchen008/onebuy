package com.vanroid.onebuy.common;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vanroid.onebuy.common.QCTest;

/**
*@author kaiscript
*@date 2016年3月13日 下午4:50:16
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class QTest {
	
	
	@Value(value="#{qcloud}")
	private QCTest q;
	
	@Autowired
	private QCTest qcloud;
	
	@Test
	public void test(){
		System.out.println(qcloud.getApp());
	}
}
