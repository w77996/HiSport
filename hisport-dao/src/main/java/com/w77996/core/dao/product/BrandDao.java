package com.w77996.core.dao.product;

import java.util.List;

import com.w77996.core.product.Brand;
import com.w77996.core.product.BrandQuery;

public interface BrandDao {
	
	public List<Brand> selectBrandList(BrandQuery brandQuery);

}
