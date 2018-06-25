package com.ddc.template.modules.sys.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ddc.template.modules.sys.entity.GoodsEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsServiceTest {
	
	@Autowired
	private GoodsService goodsService;

	@Test
	public void testUpdateForSet() {
		GoodsEntity goods = new GoodsEntity();
		goods.setGoodsId(3L);
		boolean updateForSet = goodsService.updateForSet("name=''", new EntityWrapper<>(goods));
		Assert.assertTrue(updateForSet);
	}
	
	@Test
	public void testTracation(){
		goodsService.testUpdateListTraction();
	}

}
