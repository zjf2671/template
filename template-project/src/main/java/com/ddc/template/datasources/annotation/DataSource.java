package com.ddc.template.datasources.annotation;

import java.lang.annotation.*;

/**
 * 多数据源注解
 * @author harry.zhang
 * 
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default "";
}
