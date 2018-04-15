package com.ddc.template.modules.sys.dao;


import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ddc.template.modules.sys.entity.SysLogEntity;

/**
 * 系统日志
 * 
 * @author harry.zhang
 */
@Mapper
public interface SysLogDao extends BaseMapper<SysLogEntity> {
	
}
