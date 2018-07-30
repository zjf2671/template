package com.ddc.template.app.modules.user.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ddc.template.app.modules.user.entity.UserEntity;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 * 
 * @author harry.zhang
 * 
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

}
