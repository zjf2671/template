package com.ddc.template.modules.sys.service;


import com.baomidou.mybatisplus.service.IService;
import com.ddc.template.common.utils.PageUtils;
import com.ddc.template.modules.sys.entity.SysLogEntity;

import java.util.Map;


/**
 * 系统日志
 * 
 * @author harry.zhang
 * 
 */
public interface SysLogService extends IService<SysLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

}
