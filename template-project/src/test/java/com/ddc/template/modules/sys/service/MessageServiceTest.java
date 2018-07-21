package com.ddc.template.modules.sys.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ddc.template.BaseSpringBootTest;
import com.google.common.collect.Lists;

public class MessageServiceTest extends BaseSpringBootTest{
	
	@Autowired
	private MessageService messageService;

	@Test
	public void testSend() {
		List<String> message = Lists.newArrayList();
    	message.add("aaa");
    	message.add("bbb");
    	message.add("ccc");
    	message.add("ddd");
    	messageService.send(message);
	}

	@Test
	public void testSendAndReceive() {
		List<String> message = Lists.newArrayList();
    	message.add("aaa....");
    	message.add("bbb....");
    	message.add("ccc....");
    	message.add("ddd....");
    	messageService.sendAndReceive(message);
	}

}
