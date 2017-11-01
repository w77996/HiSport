package com.w77996.core.dao.product;

import java.util.List;

import com.w77996.core.bean.product.Brand;
import com.w77996.core.bean.product.BrandQuery;

public interface BrandDao {

	//查询结果集
	public List<Brand> selectBrandListByQuery(BrandQuery brandQuery);
	//查询总条数
	public Integer selectCount(BrandQuery brandQuery);
	//通过ID查询品牌
	public Brand selectBrandById(Long id);
	
	
	
}
