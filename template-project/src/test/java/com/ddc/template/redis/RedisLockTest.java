package com.ddc.template.redis;

import com.ddc.template.BaseSpringBootTest;
import com.ddc.template.common.utils.RedisDistributedLock;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RedisLockTest extends BaseSpringBootTest {

    @Autowired
    private RedisDistributedLock redisDistributedLock;

    private String lockKey = "test:lock";

    @Test
    public void testLock(){

        ExecutorService executor = Executors.newCachedThreadPool();
        try{
            List<Callable<String>> callList = Lists.newArrayList();
            Callable<String> call = () -> {
                try{
                    //获取锁
                    boolean result = redisDistributedLock.acquireLock(lockKey, 2);
                    if(result){
                        //实现业务逻辑
                        System.out.println(Thread.currentThread() + "  acquire read lock");
                        Thread.sleep(1000);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    //释放锁
                    String requestId =  redisDistributedLock.lockFlag.get();
                    System.out.println("requestId:"+requestId);
                    boolean releaseLock = redisDistributedLock.releaseLock(lockKey, requestId);
                    if(releaseLock){
                        System.out.println(Thread.currentThread() + " 没有超时正常释放 release read lock");
                    }
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
            System.out.println("lockFlag："+redisDistributedLock.lockFlag.get());
            Thread.sleep(100000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
