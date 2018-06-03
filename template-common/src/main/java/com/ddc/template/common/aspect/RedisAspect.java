package com.ddc.template.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.ddc.template.common.exception.BusinessException;

/**
 * @Description: Redis切面处理类 
 * @author harry.zhang
 * @CreateDate:	2018年3月25日
 * @version 1.0
 */
@Aspect
@Configuration
public class RedisAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());
    //是否开启redis缓存  true开启   false关闭
    @Value("${template.redis.open: false}")
    private boolean open;

    @Around("execution(* com.ddc.template.common.utils.RedisUtils.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        if(open){
            try{
                result = point.proceed();
            }catch (Exception e){
                logger.error("redis error", e);
                throw new BusinessException("Redis服务异常");
            }
        }
        return result;
    }
}
