package com.ddc.template.component.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.ddc.template.component.util.MqConstants;

/**
 * 消息消费者
 * @author harry.zhang
 * @date 2018年6月27日下午2:30:03
 */
@Component
public class MessageReceiver {
    private static final Logger log = LoggerFactory.getLogger(MessageReceiver.class);

    /**
     * 无返回消息的
     *
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = MqConstants.QUEUE_NAME, durable = "true", exclusive = "false", autoDelete = "false"),
            exchange = @Exchange(value = MqConstants.EXCHANGES_NAME, ignoreDeclarationExceptions = "true",  autoDelete = "false"),
            key = MqConstants.ROUTING_KEY))
    public void receive(byte[] message) {
        log.info(">>>>>>>>>>> receive：" + new String(message));
    }

    /**
     * 设置有返回消息的
     * 需要注意的是，
     * 1. 在消息的在生产者（发送消息端）一定要使用 SendAndReceive(……) 这种带有 receive 的方法，否则会抛异常，不捕获会死循环。
     * 2. 该方法调用时会锁定当前线程，并且有可能会造成MQ的性能下降或者服务端/客户端出现死循环现象，请谨慎使用。
     *
     * @param message
     * @return
     */
    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = MqConstants.QUEUE_NAME, durable = "true", exclusive = "false", autoDelete = "false"),
            exchange = @Exchange(value = MqConstants.EXCHANGES_NAME, ignoreDeclarationExceptions = "true", autoDelete = "false"),
            key = MqConstants.ROUTING_REPLY_KEY))
    public String receiveAndReply(byte[] message) {
        log.info(">>>>>>>>>>> receive：" + new String(message));
        return ">>>>>>>> I got the message";
    }

}
