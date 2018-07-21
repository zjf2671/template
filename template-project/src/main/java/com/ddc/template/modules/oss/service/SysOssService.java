package com.ddc.template.modules.oss.service;

import com.baomidou.mybatisplus.service.IService;
import com.ddc.template.common.utils.PageUtils;
import com.ddc.template.modules.oss.entity.SysOssEntity;

import java.util.Map;

/**
 * 文件上传
 * 
 * @author harry.zhang
 * 
 */
public interface SysOssService extends IService<SysOssEntity> {

	PageUtils queryPage(Map<String, Object> params);
}
