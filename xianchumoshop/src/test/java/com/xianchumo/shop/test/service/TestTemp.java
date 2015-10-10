package com.xianchumo.shop.test.service;

import org.junit.Test;

import com.xianchumo.shop.util.ShopUtil;

public class TestTemp {
	@Test
	public void test() {
		System.out.println('Z' + 0);
		System.out.println('A' + 0);

		for (int i = 0; i < 200; i++) {
			long t = System.currentTimeMillis();
			int a = (int) (Math.random() * 100);
			System.out.println((int) (t + a) / 20);
		}

	}

	@Test
	public void testUtil() {
			System.out.println(ShopUtil.createOrderNumber());
	}
}
