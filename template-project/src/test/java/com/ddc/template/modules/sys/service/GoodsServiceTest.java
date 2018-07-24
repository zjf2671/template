package com.ddc.template.modules.sys.service;

import com.ddc.template.common.utils.RedisDistributedLock;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ddc.template.BaseSpringBootTest;
import com.ddc.template.modules.sys.entity.GoodsEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;

public class GoodsServiceTest extends BaseSpringBootTest{
	
	@Autowired
	private GoodsService goodsService;

	@Autowired
	private RedisDistributedLock redisDistributedLock;

	@Test
	public void testUpdateForSet() {
		GoodsEntity goods = new GoodsEntity();
		goods.setGoodsId(3L);
		boolean updateForSet = goodsService.updateForSet("name="+goods.getName(), new EntityWrapper<>(goods));
		Assert.assertTrue(updateForSet);
	}
	
	@Test
	public void testTracation(){
		goodsService.testUpdateListTransaction();
	}

	@Test
	public void testLock(){
		ExecutorService executor = Executors.newCachedThreadPool();
		try{
			List<Callable<String>> callList = new ArrayList<>();
			Callable<String> call = () -> {
				try{
					//获取锁
					redisDistributedLock.acquireLock("aaa",1000);
					System.out.println(Thread.currentThread() + "  acquire read lock");
					Thread.sleep(2000);
				}catch (Exception e){
				}finally {
					//释放锁
					redisDistributedLock.releaseLock("aaa",UUID.randomUUID().toString());
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

}
