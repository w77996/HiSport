package com.w77996.core.service.product;

import java.util.List;

import com.w77996.core.bean.product.Color;
import com.w77996.core.bean.product.Product;

import cn.itcast.common.page.Pagination;

public interface ProductService {
	
	
	//分页对象
	public Pagination selectPaginationByQuery(Integer pageNo,String name
			,Long brandId,Boolean isShow);
	
	//颜色结果集
	public List<Color> selectColorList();
	
	//商品保存
	public void insertProduct(Product product);
	
	
	//上架
	public void isShow(Long[] ids);

}

