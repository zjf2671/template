package com.ddc.template.component.mq;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.ddc.template.common.validator.Assert;
import com.ddc.template.component.util.MqConstants;

/**
 * 生产者
 * @author harry.zhang
 * @date 2018年6月27日下午2:30:11
 */
@Component
public class MessageSender implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    /**
     * logger
     */
    private static final Logger log = LoggerFactory.getLogger(MessageSender.class);
    private RabbitTemplate rabbitTemplate;

    /**
     * 注入 RabbitTemplate
     */
    @Autowired
    public MessageSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitTemplate.setConfirmCallback(this);
        this.rabbitTemplate.setReturnCallback(this);
//        this.rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter()); //如果加了这个消费方也要用这种方式反解出来。不然拿到的是犹如[22，33，44，55]这种数据
    }

    /**
     * 测试无返回消息的
     */
    public void send(Object message) {
    	Assert.isNull(message, "发送消息不能为空");
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        log.info("发送的消息{}",correlationData.toString());
        rabbitTemplate.convertAndSend(MqConstants.EXCHANGES_NAME, MqConstants.ROUTING_KEY, JSON.toJSONString(message), correlationData);
        log.info(">>>>>>>>>> Already sent message");
    }

    /**
     * 测试有返回消息的，需要注意一些问题
     */
    public void sendAndReceive(Object message) {
    	Assert.isNull(message, "发送消息不能为空");
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        Object o = rabbitTemplate.convertSendAndReceive(MqConstants.EXCHANGES_NAME, MqConstants.ROUTING_REPLY_KEY, JSON.toJSONString(message), correlationData);
        log.info(">>>>>>>>>>> {}", JSON.toJSONString(o));
    }

    /**
     * Confirmation callback.
     *
     * @param correlationData correlation data for the callback.
     * @param ack             true for ack, false for nack
     * @param cause           An optional cause, for nack, when available, otherwise null.
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            log.info(">>>>>>> 消息id:{} 发送成功", correlationData.getId());
        } else {
            log.info(">>>>>>> 消息id:{} cause:{}发送失败", correlationData.getId(), cause);
        }
    }

    /**
     * Returned message callback.
     *
     * @param message    the returned message.
     * @param replyCode  the reply code.
     * @param replyText  the reply text.
     * @param exchange   the exchange.
     * @param routingKey the routing key.
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
    	log.info("消息return-message:[{}] replyCode:[{}] replyText:[{}] exchange:[{}] routingKey:[{}] 发送失败",
				new String(message.getBody()), replyCode, replyText, exchange, routingKey);
    }
}
