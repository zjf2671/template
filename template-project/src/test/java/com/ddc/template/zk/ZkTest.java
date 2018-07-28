package com.ddc.template.zk;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ddc.template.BaseSpringBootTest;
import com.ddc.template.common.utils.ZkLockUtil;

public class ZkTest extends BaseSpringBootTest{
	
	@Autowired
	private InterProcessMutex interProcessMutex;
	
	@Autowired
	private ZkLockUtil zkLockUtil;
	
	@Test
	public void testZkLock(){
		ExecutorService executor = Executors.newCachedThreadPool();
        try{
            List<Callable<String>> callList = new ArrayList<>();
            Callable<String> call = () -> {
                try{
                    //获取锁
                    boolean acquire = zkLockUtil.acquire(5, TimeUnit.SECONDS);
                    if(acquire){
                        System.out.println(Thread.currentThread() + "  acquire read lock");
                        Thread.sleep(9000);
                    }
                }catch (Exception e){
                }finally {
                    //释放锁
                	zkLockUtil.release();
                    System.out.println(Thread.currentThread() + "  release read lock");
                }
                return "true";
            };
            //5个并发线程
            for (int i = 0; i < 5; i++) {
                callList.add(call);
            }
            List<Future<String>> futures = executor.invokeAll(callList);
            for(Future<String> ruslut:futures){
            	System.out.println(ruslut.get());
            }
        }catch (Exception e){

        }
    
		
	}
	
	@Test
	public void testZk(){
		 ExecutorService executor = Executors.newCachedThreadPool();
       Consumer<InterProcessMutex> consumer = (InterProcessMutex typeLock)->{
           try{
               List<Callable<String>> callList = new ArrayList<>();
               Callable<String> call = () -> {
                   try{
                       //获取锁
                   	typeLock.acquire(1000,TimeUnit.SECONDS);
                       System.out.println(Thread.currentThread() + "  acquire read lock");
                       Thread.sleep(2000);
                   }catch (Exception e){
                   }finally {
                       //释放锁
                   	typeLock.release();
                       System.out.println(Thread.currentThread() + "  release read lock");
                   }
                   return "true";
               };
               //5个并发线程
               for (int i = 0; i < 5; i++) {
                   callList.add(call);
               }
               List<Future<String>> futures = executor.invokeAll(callList);
               for(Future<String> ruslut:futures){
               	System.out.println(ruslut.get());
               }
           }catch (Exception e){

           }
       };
       
       //分布式锁测试
       consumer.accept(interProcessMutex);

       executor.shutdown();
	}

}
