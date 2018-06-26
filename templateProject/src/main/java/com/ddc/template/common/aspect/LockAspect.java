package com.ddc.template.common.aspect;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/**
 * 同步锁 AOP
 * @author harry.zhang
 * @date 2018年6月26日上午9:51:33
 * @transaction 以及 order 说明
 */
@Component
@Scope
@Aspect
@Order(1)
//order越小越是最先执行，但更重要的是最先执行的最后结束。order默认值是2147483647
public class LockAspect {
	/**
     * service 默认是单例的，并发下lock只有一个实例
     */
	private static  Lock lock = new ReentrantLock(true);//互斥锁 参数默认false，不公平锁  
	
	//Service层切点     用于记录错误日志
	@Pointcut("@annotation(com.ddc.template.common.annotation.Servicelock)")  
	public void lockAspectPoint() {
		
	}
	
    @Around("lockAspectPoint()")
    public  Object around(ProceedingJoinPoint joinPoint) throws Throwable { 
    	System.out.println("开始lock");
    	lock.lock();
    	Object obj = null;
		try {
			obj = joinPoint.proceed();
		} finally{
			lock.unlock();
			System.out.println("结束unlock");
		}
    	return obj;
    } 
}