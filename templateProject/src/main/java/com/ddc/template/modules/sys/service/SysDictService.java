package com.ddc.template.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.ddc.template.common.utils.PageUtils;
import com.ddc.template.modules.sys.entity.SysDictEntity;

import java.util.Map;

/**
 * 数据字典表
 *
 * @author harry.zhang
 */
public interface SysDictService extends IService<SysDictEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

