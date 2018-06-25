package com.ddc.template.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.ddc.template.common.utils.PageUtils;
import com.ddc.template.modules.sys.entity.GoodsEntity;

import java.util.Map;

/**
 * 商品管理
 *
 * @author harry.zhang
 */
public interface GoodsService extends IService<GoodsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    public void testUpateTransaction(Integer num1, Integer num2);
    
    public void testUpdateListTransaction();
}

