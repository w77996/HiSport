package com.w77996.core.service.product;

import com.w77996.core.bean.product.Brand;

import cn.itcast.common.page.Pagination;

public interface BrandService {
	public Pagination selectPaginationByQuery(String name,Integer isDisplay,Integer pageNo);
	
	public Brand selectBrandById(Long id);
	
	//public Brand selectCount(Long id);
	

	public void updateBrandById(Brand brand);
	
	
	public void deletes(Long[] ids);
}
