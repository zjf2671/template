package com.ddc.template;


import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ddc.template.modules.sys.entity.SysUserEntity;
import com.ddc.template.service.DataSourceTestService;


public class DynamicDataSourceTest extends BaseSpringBootTest{
    @Autowired
    private DataSourceTestService dataSourceTestService;

    @Test
    public void test(){
        //数据源1
        SysUserEntity user1 = dataSourceTestService.queryUser(1L);
        System.out.println(ToStringBuilder.reflectionToString(user1));

        //数据源2
        SysUserEntity user2 = dataSourceTestService.queryUser2(1L);
        System.out.println(ToStringBuilder.reflectionToString(user2));

        //数据源1
        SysUserEntity user3 = dataSourceTestService.queryUser(1L);
        System.out.println(ToStringBuilder.reflectionToString(user3));
    }

}
