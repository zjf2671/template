package com.ddc.template.manage.user;

import com.ddc.template.vo.SysUserVO;

public interface SysUserManage {
	
	/**
	 * 调用权限服务进行登录
	 * @param userName
	 * @param password
	 * @return
	 */
	public SysUserVO login(String userName, String password, Integer shopId);
	
}
