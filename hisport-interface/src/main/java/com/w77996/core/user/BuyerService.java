package com.w77996.core.user;

import com.w77996.core.bean.user.Buyer;

public interface BuyerService {
	
	//通过用户名查询用户对象
	public Buyer selectBuyerByUsername(String username);

}
