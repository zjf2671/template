package com.ddc.template.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ddc.template.modules.sys.entity.SysDictEntity;

/**
 * 数据字典
 *
 * @author harry.zhang
 */
@Mapper
public interface SysDictDao extends BaseMapper<SysDictEntity> {
	
}
