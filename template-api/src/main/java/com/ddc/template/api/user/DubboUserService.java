package com.ddc.template.api.user;

import com.ddc.template.model.user.UserDTO;

/**
 * @author harry.zhang
 */
public interface DubboUserService {
	
	/**
	 * 通过手机查询用户信息
	 * @param mobile 手机号
	 * @return
	 */
	UserDTO queryByMobile(String mobile);
	
}
