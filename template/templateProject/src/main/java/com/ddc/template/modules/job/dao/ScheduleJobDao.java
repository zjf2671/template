package com.ddc.template.modules.job.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ddc.template.modules.job.entity.ScheduleJobEntity;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 定时任务
 *
 * @author harry.zhang
 */
@Mapper
public interface ScheduleJobDao extends BaseMapper<ScheduleJobEntity> {
	
	/**
	 * 批量更新状态
	 */
	int updateBatch(Map<String, Object> map);
}
