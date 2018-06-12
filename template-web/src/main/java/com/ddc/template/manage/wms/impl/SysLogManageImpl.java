package com.ddc.template.manage.wms.impl;

import org.springframework.stereotype.Service;

import com.ddc.template.common.utils.PageUtils;
import com.ddc.template.manage.wms.SysLogManage;
import com.ddc.template.model.Pagination;
import com.ddc.template.vo.SysLogVO;

@Service
public class SysLogManageImpl implements SysLogManage {
	
	
	@Override
	public void insert(SysLogVO sysLogVO){
	}

	@Override
	public PageUtils queryPage(Pagination page) {
		return new PageUtils(null, 0, page.getPageSize(), page.getCurrPage());
	}

}
