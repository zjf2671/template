package com.ddc.template.modules.oss.dao;


import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ddc.template.modules.oss.entity.SysOssEntity;

/**
 * 文件上传
 * 
 * @author harry.zhang
 */
@Mapper
public interface SysOssDao extends BaseMapper<SysOssEntity> {
	
}
