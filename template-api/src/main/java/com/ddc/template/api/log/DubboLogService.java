package com.ddc.template.api.log;

import com.ddc.template.model.log.SysLogDTO;

public interface DubboLogService {
	
	public SysLogDTO queryLogById(Long logId);

}
