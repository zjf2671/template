package com.ddc.template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddc.template.datasources.DataSourceNames;
import com.ddc.template.datasources.annotation.DataSource;
import com.ddc.template.modules.sys.entity.SysUserEntity;
import com.ddc.template.modules.sys.service.SysUserService;

/**
 * 测试多数据源
 *
 * @author harry.zhang
 */
@Service
public class DataSourceTestService {
    @Autowired
    private SysUserService sysUserService;

    public SysUserEntity queryUser(Long userId){
        return sysUserService.selectById(userId);
    }

    @DataSource(name = DataSourceNames.SECOND)
    public SysUserEntity queryUser2(Long userId){
        return sysUserService.selectById(userId);
    }
}
