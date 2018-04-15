package com.ddc.template.modules.sys.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ddc.template.modules.sys.entity.SysLogEntity;

import org.apache.ibatis.annotations.Mapper;

/**
 * 系统日志
 * 
 * @author harry.zhang
 * 
 */
@Mapper
public interface SysLogDao extends BaseMapper<SysLogEntity> {
	
}
