package com.w77996.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.w77996.core.bean.TestTb;
import com.w77996.core.dao.TestTbDao;



/**
 * 测试
 * @author lx
 *
 */
@Service("testTbService")
@Transactional
public class TestTbServiceImpl implements TestTbService {

	
	@Autowired
	private TestTbDao testTbDao;
	
	public void insertTestTb(TestTb testTb){
		testTbDao.insertTestTb(testTb);
		//throw new RuntimeException();
	}

	
}
