package com.ddc.template.common.aspect;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ddc.template.common.annotation.SysLog;
import com.ddc.template.common.utils.HttpContextUtils;
import com.ddc.template.common.utils.IPUtils;
import com.ddc.template.manage.wms.SysLogManage;
import com.ddc.template.vo.SysLogVO;
import com.ddc.template.vo.SysUserVO;
import com.google.gson.Gson;


/**
 * @Description: 系统日志，切面处理类 
 * @author harry.zhang
 * @CreateDate:	2018年3月25日
 * @version 1.0
 */
@Aspect
@Component
public class SysLogAspect{
	@Autowired
	private SysLogManage sysLogManage;
	
	@Pointcut("@annotation(com.ddc.template.common.annotation.SysLog)")
	public void logPointCut() { 
		
	}

	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		long beginTime = System.currentTimeMillis();
		//执行方法
		Object result = point.proceed();
		//执行时长(毫秒)
		long time = System.currentTimeMillis() - beginTime;

		//保存日志
		saveSysLog(point, time);

		return result;
	}

	private void saveSysLog(ProceedingJoinPoint joinPoint, long time) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();

		SysLogVO sysLog = new SysLogVO();
		SysLog syslog = method.getAnnotation(SysLog.class);
		if(syslog != null){
			//注解上的描述
			sysLog.setOperation(syslog.value());
		}

		//请求的方法名
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = signature.getName();
		sysLog.setMethod(className + "." + methodName + "()");

		//请求的参数
		Object[] args = joinPoint.getArgs();
		try{
			String params = new Gson().toJson(args[0]);
			sysLog.setParams(params);
		}catch (Exception e){

		}

		//获取request
		HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
		//设置IP地址
		sysLog.setIp(IPUtils.getIpAddr(request));

		//用户名
		String username = ((SysUserVO)request.getSession().getAttribute("sysUser")).getUsername();
		sysLog.setUsername(username);

		sysLog.setTime(time);
		sysLog.setCreateTime(new Date());
		//保存系统日志
		sysLogManage.insert(sysLog);
	}
}
