package com.ddc.template.manage.wms;

import com.ddc.template.common.utils.PageUtils;
import com.ddc.template.model.Pagination;
import com.ddc.template.vo.SysLogVO;

public interface SysLogManage {
	
	public void insert(SysLogVO sysLogVO);

	public PageUtils queryPage(Pagination page);

}
