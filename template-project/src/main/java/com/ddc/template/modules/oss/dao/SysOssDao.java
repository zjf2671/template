package com.ddc.template.modules.oss.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ddc.template.modules.oss.entity.SysOssEntity;

import org.apache.ibatis.annotations.Mapper;

/**
 * 文件上传
 * 
 * @author harry.zhang
 * 
 */
@Mapper
public interface SysOssDao extends BaseMapper<SysOssEntity> {
	
}
