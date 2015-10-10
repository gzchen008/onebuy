package com.xianchumo.shop.test.entity;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.xianchumo.shop.entity.CartItem;
import com.xianchumo.shop.entity.Good;

public class CartItemTest {
	@Test
	public void test() {
		Set<CartItem> set = new HashSet<CartItem>();
		CartItem e = new CartItem();
		CartItem e2 = new CartItem();
		Good good = new Good();
		Good good2 = new Good();
		good.setGid(1l);
		good2.setGid(1l);
		good.setName("abc");
		good2.setName("23222");
		e.setGood(good);
		e2.setGood(good2);
		set.add(e);
		set.add(e2);
		System.out.println(set.size());
		for (CartItem c : set) {
			System.out.println(c.getGood().getName());
		}
	}
}
