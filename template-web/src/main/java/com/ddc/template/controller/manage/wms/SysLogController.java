package com.ddc.template.controller.manage.wms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ddc.template.common.utils.PageUtils;
import com.ddc.template.common.utils.R;
import com.ddc.template.controller.manage.AbstractController;
import com.ddc.template.manage.wms.SysLogManage;
import com.ddc.template.model.Pagination;


/**
 * 系统日志
 * 
 * @author harry.zhang
 * 
 */
@RestController
@RequestMapping("/sys/log")
public class SysLogController extends AbstractController{
	@Autowired
	private SysLogManage sysLogManage;
	
	/**
	 * 列表
	 */
	@GetMapping("/list")
	public R list(Pagination pageParams){
		PageUtils page = sysLogManage.queryPage(pageParams);
		return R.ok().put("page", page);
	}
	
}
