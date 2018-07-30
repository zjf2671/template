package com.ddc.template.app.modules.user.service;


import com.baomidou.mybatisplus.service.IService;
import com.ddc.template.app.modules.user.entity.UserEntity;
import com.ddc.template.app.modules.user.form.LoginForm;

/**
 * 用户
 * 
 * @author harry.zhang
 * 
 */
public interface UserService extends IService<UserEntity> {

	UserEntity queryByMobile(String mobile);

	/**
	 * 用户登录
	 * @param form    登录表单
	 * @return        返回用户ID
	 */
	long login(LoginForm form);
}
