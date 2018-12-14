package com.ldh.hplus.mq.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldh.hplus.common.action.SuperAction;
import com.ldh.hplus.producer.activemq.Producer;

@Controller
@RequestMapping("mq")
public class SendMsgAction extends SuperAction {
	
	@Resource
	Producer producer;

	@RequestMapping("sendMsg")
	@ResponseBody
	public void sendMsg(String name,String msg){
		
		System.out.println(msg);
		
		producer.sendMsg(name, msg);
		
		
	}
}
