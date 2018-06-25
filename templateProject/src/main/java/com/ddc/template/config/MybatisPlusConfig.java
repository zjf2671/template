package com.ddc.template.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
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
     * 乐观锁插件
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor () {
    	return new OptimisticLockerInterceptor();
    }
    
    /**
     * 自定义数据源切换
     */
    @Bean
    public DynamicDataSourceInterceptor dynamicDataSourceInterceptor(){
    	return new DynamicDataSourceInterceptor();
    }
    
}
