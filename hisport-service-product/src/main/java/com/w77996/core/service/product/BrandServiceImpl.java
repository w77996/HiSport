package com.w77996.core.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.w77996.core.bean.product.Brand;
import com.w77996.core.bean.product.BrandQuery;
import com.w77996.core.dao.product.BrandDao;

import cn.itcast.common.page.Pagination;

@Service("brandService")
@Transactional
public class BrandServiceImpl implements BrandService{

	@Autowired
	private BrandDao brandDao;
	public Pagination selectPaginationByQuery(String name,Integer isDisplay,Integer pageNo){
		BrandQuery brandQuery = new BrandQuery();
		brandQuery.setPageNo(Pagination.cpn(pageNo));
		brandQuery.setPageSize(2);

		StringBuilder params = new StringBuilder();
		
		//条件
		if(null != name){
			brandQuery.setName(name);
			params.append("name=").append(name);
		}
		if(null != isDisplay){
			brandQuery.setIsDisplay(isDisplay);
			params.append("&isDisplay=").append(isDisplay);
		}else{
			brandQuery.setIsDisplay(1);
			params.append("&isDisplay=").append(1);
		}
		
		Pagination pagination = new Pagination(
				brandQuery.getPageNo(),
				brandQuery.getPageSize(),
				brandDao.selectCount(brandQuery)
				);
		//设置结果集
		pagination.setList(brandDao.selectBrandListByQuery(brandQuery));
		//分页展示
		String url = "/brand/list.do";
		
		pagination.pageView(url, params.toString());
		
		return pagination;
	}
	@Override
	public Brand selectBrandById(Long id) {
		// TODO Auto-generated method stub
		return brandDao.selectBrandById(id);
	}
}
