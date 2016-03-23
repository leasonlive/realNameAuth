package com.zxhy.simple.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:ApplicationContextMybatis.xml","classpath:ApplicationContextWorkflow.xml"})
public class RealNameAuthServiceTest {
	@Autowired
	private RealNameAuthService realNameAuthService;
	@Test
	public void register(){
		this.realNameAuthService.register("138", "1234");
	}
	@Test
	public void updateRealName(){
		this.realNameAuthService.updateRealName("138", "3201", "理");
		this.realNameAuthService.updatePhoto("138", "http://home.baidu.com/resource/r/image/2012-12-11/33fc59dbb24ce61c883227031d958ba9.jpg");
		this.realNameAuthService.updateFace("138", "https://www.baidu.com/img/bd_logo1.png");
	}
}
