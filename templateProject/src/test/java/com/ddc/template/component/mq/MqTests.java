package com.ddc.template.component.mq;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ddc.template.BaseSpringBootTest;

public class MqTests extends BaseSpringBootTest{

    @Autowired
    private MessageSender sender;

    @Test
    public void send() {
        sender.send();
    }

    @Test
    public void sendAndReceive() {
        sender.sendAndReceive();
    }
}
