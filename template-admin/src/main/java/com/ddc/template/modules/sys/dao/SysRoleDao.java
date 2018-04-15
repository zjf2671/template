package com.ddc.template.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ddc.template.modules.sys.entity.SysRoleEntity;

/**
 * 角色管理
 * 
 * @author harry.zhang
 */
@Mapper
public interface SysRoleDao extends BaseMapper<SysRoleEntity> {
	

}
