package com.w77996;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.w77996.core.bean.TestTb;
import com.w77996.core.bean.product.Brand;
import com.w77996.core.bean.product.BrandQuery;
import com.w77996.core.dao.product.BrandDao;
import com.w77996.core.service.TestTbService;
import com.w77996.core.service.product.BrandService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class BrandTest {

	@Autowired
	private BrandService brandService;
	
	@Test 
	public void testBrand() throws Exception{
		BrandQuery brandQuery = new BrandQuery();
		Brand data = brandService.selectBrandById(1L);
		System.out.println(data.toString());
	}
}
