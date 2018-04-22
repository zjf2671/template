package com.ddc.template.app.modules.user.service.impl;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ddc.template.app.modules.user.dao.UserDao;
import com.ddc.template.app.modules.user.entity.UserEntity;
import com.ddc.template.app.modules.user.form.LoginForm;
import com.ddc.template.app.modules.user.service.UserService;
import com.ddc.template.common.exception.BusinessException;
import com.ddc.template.common.validator.Assert;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

	@Override
	public UserEntity queryByMobile(String mobile) {
		UserEntity userEntity = new UserEntity();
		userEntity.setMobile(mobile);
		return baseMapper.selectOne(userEntity);
	}

	@Override
	public long login(LoginForm form) {
		UserEntity user = queryByMobile(form.getMobile());
		Assert.isNull(user, "手机号或密码错误");

		//密码错误
		if(!user.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))){
			throw new BusinessException("手机号或密码错误");
		}

		return user.getUserId();
	}
}
