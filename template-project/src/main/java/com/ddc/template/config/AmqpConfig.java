package com.ddc.template.config;
import com.ddc.template.component.util.MqConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * rabbitmq 配置
 * @author harry.zhang
 * @date 2018年7月18日下午7:42:47
 */
@Configuration
public class AmqpConfig{
	
    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }
    
    /**
     * 统一交换机
     * @param rabbitAdmin
     * @return
     */
    @Bean
    public DirectExchange exchange(RabbitAdmin rabbitAdmin) {
    	String exchangeName = MqConstants.EXCHANGES_NAME;
    	DirectExchange exchange = new DirectExchange(exchangeName);
    	rabbitAdmin.declareExchange(exchange);
    	return exchange;
    }
    
    /**
     * test
     * @param rabbitAdmin
     * @return
     */
    @Bean
    public Queue testQueue(RabbitAdmin rabbitAdmin) {
        String queueName = MqConstants.QUEUE_NAME;
        Queue queue = new Queue(queueName,true);
        rabbitAdmin.declareQueue(queue);
        return queue;
    }

    @Bean
    public Binding testBinding(RabbitAdmin rabbitAdmin) {
        return BindingBuilder.bind(testQueue(rabbitAdmin)).to(exchange(rabbitAdmin)).with(MqConstants.ROUTING_KEY);
    }
    

}
