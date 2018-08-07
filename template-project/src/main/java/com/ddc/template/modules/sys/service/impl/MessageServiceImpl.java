package com.ddc.template.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddc.template.component.mq.MessageSender;
import com.ddc.template.modules.sys.service.MessageService;

/**
 * @author harry.zhang
 */
@Service("MessageService")
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private MessageSender messageSender;

	@Override
	public void send(Object message) {
		messageSender.send(message);

	}

	@Override
	public void sendAndReceive(Object message) {
		messageSender.sendAndReceive(message);
		
	}

}
