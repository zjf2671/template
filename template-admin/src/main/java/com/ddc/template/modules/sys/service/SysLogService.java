package com.ddc.template.modules.sys.service;


import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.ddc.template.common.utils.PageUtils;
import com.ddc.template.modules.sys.entity.SysLogEntity;


/**
 * 系统日志
 * 
 * @author harry.zhang
 */
public interface SysLogService extends IService<SysLogEntity> {

    PageUtils queryPage(Map<String, Object> params);

}
