package com.ddc.template.api.log;

import com.ddc.template.model.log.SysLogDTO;

/**
 * @author harry.zhang
 */
public interface DubboLogService {
	
	SysLogDTO queryLogById(Long logId);

}
