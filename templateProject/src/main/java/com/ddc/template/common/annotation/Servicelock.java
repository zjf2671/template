package com.ddc.template.common.annotation;
import java.lang.annotation.*; 
/**
 * 自定义注解 同步锁(只能用于第一个事务开始的地方)
 * @author harry.zhang
 * @date 2018年6月26日上午9:52:58
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})    
@Retention(RetentionPolicy.RUNTIME)    
@Documented    
public  @interface Servicelock { 
	 String description()  default "";
}