package com.ddc.template.modules.job.service;

import com.baomidou.mybatisplus.service.IService;
import com.ddc.template.common.utils.PageUtils;
import com.ddc.template.modules.job.entity.ScheduleJobLogEntity;

import java.util.Map;

/**
 * 定时任务日志
 *
 * @author harry.zhang
 */
public interface ScheduleJobLogService extends IService<ScheduleJobLogEntity> {

	PageUtils queryPage(Map<String, Object> params);
	
}
