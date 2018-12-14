package com.ldh.hplus.producer.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Li Dehuan
 * @date 2018年12月13日
 *
 */
@Service
public class Consumer {

	@JmsListener(destination="testqueue")
	public void receiveMsg(String msg) {
		
		System.out.println("<<<<<<<<<<=============收到test消息：" + msg);
	}
	
	@JmsListener(destination="livequeue")
	public void receiveLiveMsg(String msg) {
		
		System.out.println("<<<<<<<<<<=============收到live消息：" + msg);
	}
}
