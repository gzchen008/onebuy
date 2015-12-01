package com.xianchumo.shop.test.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xianchumo.shop.entity.Good;
import com.xianchumo.shop.entity.GoodInfo;
import com.xianchumo.shop.entity.Kind;
import com.xianchumo.shop.service.GoodService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/resources/applicationContext.xml")
public class GoodServiceTest {
	@Autowired
	private GoodService goodService;

	@Test
	public void testAdd() {
		Good entity = new Good();
		GoodInfo gi = new GoodInfo();
		gi.setGood(entity);
		gi.setCook("直接食用");
		gi.setImgs(new String[] { "/upload/goods/1.png", "/upload/goods/2.png", "/upload/goods/3.png" });
		gi.setIntroduce("进口大苹果，好吃，大又甜");
		entity.setInfo(gi);
		entity.setName("苹果");
		entity.setUnit("公斤");
		entity.setNowPrice(15.6);
		entity.setQuantity("500g");
		Kind kind = new Kind();
		kind.setKid(1l);
		entity.setKind(kind);
		goodService.add(entity);
	}

	@Test
	public void testFindByC() {
		List<Good> ls = goodService.findByCategory(1l);
		for (Good g : ls) {
			System.out.println(g.getName());
		}
	}

	@Test
	public void testLoad() {
		
		
		long s1 = System.currentTimeMillis();
		goodService.findByCategory(1l);
		Good good = goodService.get(1);
		long s2 = System.currentTimeMillis();
		System.out.println(s2 - s1);
		System.out.println(good.getInfo().getIntroduce());
	}

	@Test
	public void testGoodInfo() {
		//GoodInfo gi = new GoodInfo();
		Good good = goodService.get(1l);
		GoodInfo gi= good.getInfo();
		gi.setGood(good);
		gi.setCook("直接食用");
		gi.setImgs(new String[] { "/upload/goods/1.png", "/upload/goods/2.png", "/upload/goods/3.png" });
		gi.setIntroduce("进口大苹果，好吃，大又甜");
		good.setInfo(gi);
		goodService.update(good);
	}
	@Test
	public void testSearch(){
		List<Good> ls = goodService.searchByName("苹果");
		System.out.println(ls.size());
	}

}
