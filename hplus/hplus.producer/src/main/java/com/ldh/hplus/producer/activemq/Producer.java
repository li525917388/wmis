package com.ldh.hplus.producer.activemq;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Li Dehuan
 * @date 2018年12月13日
 *
 */
@Service
public class Producer {

	@Resource
	private JmsMessagingTemplate jmsMessagingTemplate;
	
	public void sendMsg(String destinationName, String msg) {
		
		System.out.println("=================>>>>>>>发送的消息：" + msg);
		
		Destination destination = new ActiveMQQueue(destinationName);
		
		jmsMessagingTemplate.convertAndSend(destination, msg);
	}
}
