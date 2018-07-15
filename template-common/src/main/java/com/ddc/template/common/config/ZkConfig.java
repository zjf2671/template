package com.ddc.template.common.config;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * zk分布式锁配置
 * @author Harry
 */
@Configuration
public class ZkConfig {
	
    @Value("${zookeeper.address: localhost:2181}")
    private String address;
    
	@Bean
	public InterProcessMutex interProcessMutex(){
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3); 
		CuratorFramework client = CuratorFrameworkFactory.newClient(address, retryPolicy); 
        client.start();
        InterProcessMutex mutex = new InterProcessMutex(client, "/curator/lock"); 
        return mutex;
	}
	

}
