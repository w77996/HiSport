package com.w77996.core.service.product;

import java.util.List;

import com.w77996.core.bean.product.Sku;

public interface SkuService {

	//商品ID 查询 库存结果集
	public List<Sku> selectSkuListByProductId(Long productId);
	
	//修改
	public void updateSkuById(Sku sku);
}
