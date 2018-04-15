package com.ddc.template.modules.job.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ddc.template.modules.job.entity.ScheduleJobLogEntity;

import org.apache.ibatis.annotations.Mapper;

/**
 * 定时任务日志
 *
 * @author harry.zhang
 */
@Mapper
public interface ScheduleJobLogDao extends BaseMapper<ScheduleJobLogEntity> {
	
}
