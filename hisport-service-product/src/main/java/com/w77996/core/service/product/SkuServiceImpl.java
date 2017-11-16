package com.w77996.core.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.w77996.core.bean.product.Sku;
import com.w77996.core.bean.product.SkuQuery;
import com.w77996.core.dao.product.ColorDao;
import com.w77996.core.dao.product.SkuDao;


/**
 * 库存管理
 * 
 * @author lx
 *
 */
@Service("skuService")
@Transactional
public class SkuServiceImpl implements SkuService{

	
	@Autowired
	private SkuDao skuDao;
	@Autowired
	private ColorDao colorDao;
	//商品ID 查询 库存结果集
	public List<Sku> selectSkuListByProductId(Long productId){
		SkuQuery skuQuery  = new SkuQuery();
		skuQuery.createCriteria().andProductIdEqualTo(productId);
		List<Sku> skus = skuDao.selectByExample(skuQuery);
		//15   
		for (Sku sku : skus) {
			// 3条Sql  一级缓存 
			sku.setColor(colorDao.selectByPrimaryKey(sku.getColorId()));
		}
		return skus;
	}
	//修改
	public void updateSkuById(Sku sku){
		skuDao.updateByPrimaryKeySelective(sku);
	}
}
