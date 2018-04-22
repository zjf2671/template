package com.ddc.template.modules.provider;


import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.ddc.template.api.log.DubboLogService;
import com.ddc.template.common.utils.BeanCommonUtils;
import com.ddc.template.model.log.SysLogDTO;
import com.ddc.template.modules.sys.entity.SysLogEntity;
import com.ddc.template.modules.sys.service.SysLogService;


@Service(version="1.0.0")
public class DubboLogServiceImpl implements DubboLogService {

	@Autowired
	private SysLogService sysLogService;
	
	@Override
	public SysLogDTO queryLogById(Long logId) {
		SysLogEntity sysLogEntity = sysLogService.selectById(logId);
		SysLogDTO sysLogDTO = new SysLogDTO();
		if(sysLogEntity != null){
			BeanCommonUtils.copyProperties(sysLogEntity, sysLogDTO);
			return sysLogDTO;
		}else{
			return null;
		}
	}

}
