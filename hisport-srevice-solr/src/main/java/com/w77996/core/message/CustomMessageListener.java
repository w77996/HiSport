package com.w77996.core.message;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;

import com.w77996.core.service.SearchService;

public class CustomMessageListener implements MessageListener{

	@Autowired
	private SearchService searchService;
	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		ActiveMQTextMessage am = (ActiveMQTextMessage)message;
		try {
			//System.out.println("ActiveMq中的消息是:" + am.getText());
			//保存商品信息到Solr服务器
			searchService.insertProductToSolr(Long.parseLong(am.getText()));
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}