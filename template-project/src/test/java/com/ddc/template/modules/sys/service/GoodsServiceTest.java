package com.ddc.template.modules.sys.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ddc.template.BaseSpringBootTest;
import com.ddc.template.modules.sys.entity.GoodsEntity;

public class GoodsServiceTest extends BaseSpringBootTest{
	
	@Autowired
	private GoodsService goodsService;

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

}
