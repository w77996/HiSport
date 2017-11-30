package com.w77996.core.message;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;

import com.w77996.core.bean.product.Color;
import com.w77996.core.bean.product.Product;
import com.w77996.core.bean.product.Sku;
import com.w77996.core.service.CmsService;
import com.w77996.core.service.SearchService;
import com.w77996.core.staticpage.StaticPageService;

/**
 * 处理类
 * @author w77996
 *
 */
public class CustomMessageListener implements MessageListener{

	@Autowired
	private StaticPageService staticPageService;
	@Autowired
	private CmsService cmsService;
	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		ActiveMQTextMessage am = (ActiveMQTextMessage)message;
		try {
			System.out.println("ActiveMq中的消息是-cms:" + am.getText());
			String id = am.getText();
			//数据
			Map<String,Object> root = new HashMap<>();
			//商品
			Product product = cmsService.selectProductById(Long.parseLong(id));
			//sku
			List<Sku> skus = cmsService.selectSkuListByProductId(Long.parseLong(id));
			
			//遍历一次  相同不要
			Set<Color> colors = new HashSet<>();
			for (Sku sku : skus) {
				colors.add(sku.getColor());
			}
			root.put("product", product);
			root.put("skus", skus);
			root.put("colors", colors);
			//静态化
			staticPageService.productStaticPage(root, id);
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}