package com.ddc.template.datasources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 动态数据源
 * @author harry.zhang
 * 
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
    protected static Logger logger = LoggerFactory.getLogger(DynamicDataSource.class);

    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSources) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
        }

    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSource();
    }

    public static void setDataSource(String dataSource) {
    	logger.debug("所使用的数据源为："+dataSource);
        contextHolder.set(dataSource);
    }

    public static String getDataSource() {
    	String dataSource = contextHolder.get();
    	if(dataSource == null){
    		return DataSourceNames.FIRST;
    	}
        return dataSource;
    }

    public static void clearDataSource() {
        contextHolder.remove();
    }

}
