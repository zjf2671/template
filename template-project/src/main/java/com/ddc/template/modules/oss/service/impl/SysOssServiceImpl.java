package com.ddc.template.modules.oss.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ddc.template.common.utils.PageUtils;
import com.ddc.template.common.utils.Query;
import com.ddc.template.modules.oss.dao.SysOssDao;
import com.ddc.template.modules.oss.entity.SysOssEntity;
import com.ddc.template.modules.oss.service.SysOssService;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author harry.zhang
 */
@Service("sysOssService")
public class SysOssServiceImpl extends ServiceImpl<SysOssDao, SysOssEntity> implements SysOssService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<SysOssEntity> page = this.selectPage(
				new Query<SysOssEntity>(params).getPage()
		);

		return new PageUtils(page);
	}
	
}
