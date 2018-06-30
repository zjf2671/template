package com.ddc.template.component.mq;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ddc.template.BaseSpringBootTest;
import com.google.common.collect.Lists;

public class MqTests extends BaseSpringBootTest{

    @Autowired
    private MessageSender sender;

    @Test
    public void send() {
    	List<String> message = Lists.newArrayList();
    	message.add("aaa");
    	message.add("bbb");
    	message.add("ccc");
    	message.add("ddd");
		sender.send(message);
    }

    @Test
    public void sendAndReceive() {
		sender.sendAndReceive("把我发过去哦。。。。这个是会有返回值的消息");
    }
}
