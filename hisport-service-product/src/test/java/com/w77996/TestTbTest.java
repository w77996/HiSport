package com.w77996;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.w77996.core.bean.TestTb;
import com.w77996.core.service.TestTbService;



/**
 * 测试类  junit + Spring 
 * @author lx
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class TestTbTest {

	@Autowired
	private TestTbService testTbService;
	
	@Test
	public void testAdd() throws Exception {
		TestTb testTb = new TestTb();
		testTb.setName("范冰冰2");
		testTb.setBirthday(new Date());
		
		testTbService.insertTestTb(testTb);
		
		
	}
}
