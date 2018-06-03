package com.ddc.template.facade;


import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddc.template.api.log.DubboLogService;
import com.ddc.template.model.log.SysLogDTO;

@Component
public class LogFacade {
	
	@Reference(version = "1.0.0")
	private DubboLogService dubboLogService;
	
	public SysLogDTO queryLogById(Long id){
		return dubboLogService.queryLogById(id);
	}
	
}
