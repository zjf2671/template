package com.ddc.template.modules.sys.dao;

import com.ddc.template.modules.sys.entity.GoodsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品管理
 * 
 * @author harry.zhang
 */
@Mapper
public interface GoodsDao extends BaseMapper<GoodsEntity> {
	
}
