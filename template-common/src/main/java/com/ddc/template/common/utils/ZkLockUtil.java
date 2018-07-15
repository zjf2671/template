package com.ddc.template.common.utils;

import java.util.concurrent.TimeUnit;

import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * zookeeper 分布式锁
 * @author Harry
 *
 */
@Component
public class ZkLockUtil{
	
	@Autowired
	private InterProcessMutex interProcessMutex;
	
    //获得了锁
    public boolean acquire(long time, TimeUnit unit){
    	try {
			return interProcessMutex.acquire(time,unit);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
    
    //释放锁
    public void release(){
    	try {
    		interProcessMutex.release();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
}  
