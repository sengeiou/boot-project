//package com.xzm;
//
//import com.xzm.modules.test.service.BlogProperties;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.mock.web.MockServletContext;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class LessontwoApplicationTests {
//	private static final Log log = LogFactory.getLog(LessontwoApplicationTests.class);
//
//	@Autowired
//	private BlogProperties blogProperties;
//	@Test
//	public void contextLoads() {
//		Assert.assertEquals("程序猿DD", blogProperties.getName());
//		Assert.assertEquals("Spring Boot教程", blogProperties.getTitle());
//		Assert.assertEquals("程序猿DD正在努力写《Spring Boot教程》", blogProperties.getDesc());
//
//		log.info("随机数测试输出：");
//		log.info("随机字符串 : " + blogProperties.getValue());
//		log.info("随机int : " + blogProperties.getNumber());
//		log.info("随机long : " + blogProperties.getBignumber());
//		log.info("随机10以下 : " + blogProperties.getTest1());
//		log.info("随机10-20 : " + blogProperties.getTest2());
//
//	}
//
//
////	@Test
////	public void test1() throws Exception {
////		Assert.assertEquals("程序猿DD", blogProperties.getName());
////		Assert.assertEquals("Spring Boot教程", blogProperties.getTitle());
////		Assert.assertEquals("程序猿DD正在努力写《Spring Boot教程》", blogProperties.getDesc());
////
////		log.info("随机数测试输出：");
////		log.info("随机字符串 : " + blogProperties.getValue());
////		log.info("随机int : " + blogProperties.getNumber());
////		log.info("随机long : " + blogProperties.getBignumber());
////		log.info("随机10以下 : " + blogProperties.getTest1());
////		log.info("随机10-20 : " + blogProperties.getTest2());
////
////	}
//
//}
