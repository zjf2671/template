package com.ddc.template.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ddc.template.common.utils.PageUtils;
import com.ddc.template.common.utils.Query;

import com.ddc.template.modules.sys.dao.SysDictDao;
import com.ddc.template.modules.sys.entity.SysDictEntity;
import com.ddc.template.modules.sys.service.SysDictService;


@Service("sysDictService")
public class SysDictServiceImpl extends ServiceImpl<SysDictDao, SysDictEntity> implements SysDictService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysDictEntity> page = this.selectPage(
                new Query<SysDictEntity>(params).getPage(),
                new EntityWrapper<SysDictEntity>()
        );

        return new PageUtils(page);
    }

}
