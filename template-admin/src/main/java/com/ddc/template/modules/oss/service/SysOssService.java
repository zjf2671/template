package com.ddc.template.modules.oss.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.ddc.template.common.utils.PageUtils;
import com.ddc.template.modules.oss.entity.SysOssEntity;

/**
 * 文件上传
 * 
 * @author harry.zhang
 * 
 */
public interface SysOssService extends IService<SysOssEntity> {

	PageUtils queryPage(Map<String, Object> params);
}
