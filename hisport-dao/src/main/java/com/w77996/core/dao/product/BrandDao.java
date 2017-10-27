package com.w77996.core.dao.product;

import java.util.List;

import com.w77996.core.bean.product.Brand;
import com.w77996.core.bean.product.BrandQuery;

public interface BrandDao {
	
	public List<Brand> selectBrandListByQuery(BrandQuery brandQuery);

	public Integer selectCount(BrandQuery brandQuery);
	
	public Brand selectBrandById(Long id);
}
