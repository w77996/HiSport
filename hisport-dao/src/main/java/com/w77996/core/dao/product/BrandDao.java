package com.w77996.core.dao.product;

import com.w77996.core.bean.product.Brand;
import com.w77996.core.bean.product.BrandQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrandDao {
	
	//查询结果集
	public List<Brand> selectBrandListByQuery(BrandQuery brandQuery);
	//查询总条数
	public Integer selectCount(BrandQuery brandQuery);
	//通过ID查询品牌
	public Brand selectBrandById(Long id);
	
	//修改
	public void updateBrandById(Brand brand);
	
	//删除
	public void deletes(Long[] ids);// List<Long> ids
}