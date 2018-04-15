package com.ddc.template.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.ddc.template.datasources.DynamicDataSourceInterceptor;

/**
 * mybatis-plus配置
 *
 * @author harry.zhang
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
    
    /**
     * 自定义数据源切换
     */
    @Bean
    public DynamicDataSourceInterceptor dynamicDataSourceInterceptor(){
    	return new DynamicDataSourceInterceptor();
    }
    
}
