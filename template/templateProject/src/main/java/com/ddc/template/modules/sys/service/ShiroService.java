package com.ddc.template.modules.sys.service;

import java.util.Set;

import com.ddc.template.modules.sys.entity.SysUserEntity;
import com.ddc.template.modules.sys.entity.SysUserTokenEntity;

/**
 * shiro相关接口
 * @author harry.zhang
 * 
 */
public interface ShiroService {
    /**
     * 获取用户权限列表
     */
    Set<String> getUserPermissions(long userId);

    SysUserTokenEntity queryByToken(String token);

    /**
     * 根据用户ID，查询用户
     * @param userId
     */
    SysUserEntity queryUser(Long userId);
}
