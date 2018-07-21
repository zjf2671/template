package com.ddc.template.modules.sys.dao;

import com.ddc.template.modules.sys.entity.SysDictEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 数据字典表
 * 
 * @author harry.zhang
 */
@Mapper
public interface SysDictDao extends BaseMapper<SysDictEntity> {
	
}
