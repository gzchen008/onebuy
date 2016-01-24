package com.vanroid.onebuy.core.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vanroid.onebuy.entity.Stage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class CoreBizServiceTest {

	@Resource(name = "coreBizService")
	private CoreBizService coreBizService;
	

	@Test
	public void getCodeTest() {
		
		Stage stage = new Stage();
		stage.setId(1l);
		coreBizService.getAllCode(stage );
		System.out.println();
	}
}
