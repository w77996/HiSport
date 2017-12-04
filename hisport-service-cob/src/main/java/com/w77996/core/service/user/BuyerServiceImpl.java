package com.w77996.core.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.w77996.core.bean.user.Buyer;
import com.w77996.core.bean.user.BuyerQuery;
import com.w77996.core.dao.user.BuyerDao;
import com.w77996.core.user.BuyerService;

/**
 * 用户管理
 * @author w77996
 *
 */
@Service("buyerService")
public class BuyerServiceImpl implements BuyerService{

	@Autowired
	private BuyerDao buyerDao;
	
	//通过用户名查询用户对象
	public Buyer selectBuyerByUsername(String username){
		BuyerQuery buyerQuery = new BuyerQuery();
		buyerQuery.createCriteria().andUsernameEqualTo(username);
		
		List<Buyer> buyers = buyerDao.selectByExample(buyerQuery);
		if(null != buyers && buyers.size() > 0){
			return buyers.get(0);
		}
		return null;
	}
}
