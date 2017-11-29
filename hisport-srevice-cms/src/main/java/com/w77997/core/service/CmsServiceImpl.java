package com.w77997.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.w77996.core.bean.product.Product;
import com.w77996.core.bean.product.Sku;
import com.w77996.core.bean.product.SkuQuery;
import com.w77996.core.dao.product.ColorDao;
import com.w77996.core.dao.product.ProductDao;
import com.w77996.core.dao.product.SkuDao;
import com.w77996.core.service.CmsService;

/**
 * 评论
 * 晒单
 * 广告
 * 静态化
 * @author w77996
 *
 */
@Service("cmsService")
public class CmsServiceImpl implements CmsService{

	@Autowired
	private ProductDao productDao;
	@Autowired
	private SkuDao skuDao;
	@Autowired
	private ColorDao colorDao;
	//查询商品
	public Product selectProductById(Long productId){
		
		return productDao.selectByPrimaryKey(productId);
	}
	//查询Sku结果集 (包括颜色）  有货  
	public List<Sku> selectSkuListByProductId(Long productId){
		SkuQuery skuQuery = new SkuQuery(); //大于0
		skuQuery.createCriteria().andProductIdEqualTo(productId).andStockGreaterThan(0);
		List<Sku> skus = skuDao.selectByExample(skuQuery);
		for (Sku sku : skus) {
			sku.setColor(colorDao.selectByPrimaryKey(sku.getColorId()));
		}
		return skus;
	}
}