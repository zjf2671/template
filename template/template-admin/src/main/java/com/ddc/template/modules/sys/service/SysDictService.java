package com.ddc.template.modules.sys.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.ddc.template.common.utils.PageUtils;
import com.ddc.template.modules.sys.entity.SysDictEntity;

/**
 * 数据字典
 *
 * @author harry.zhang
 */
public interface SysDictService extends IService<SysDictEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

