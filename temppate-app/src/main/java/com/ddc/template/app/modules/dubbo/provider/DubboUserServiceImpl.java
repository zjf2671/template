package com.ddc.template.app.modules.dubbo.provider;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.ddc.template.api.user.DubboUserService;
import com.ddc.template.app.modules.user.entity.UserEntity;
import com.ddc.template.app.modules.user.service.UserService;
import com.ddc.template.common.utils.BeanCommonUtils;
import com.ddc.template.model.user.UserDTO;


@Service(version="1.0.0")
public class DubboUserServiceImpl implements DubboUserService {

	@Autowired
	private UserService userService;
	
	@Override
	public UserDTO queryByMobile(String mobile) {
		mobile.toString();
		UserEntity userEntity = userService.queryByMobile(mobile);
		UserDTO userDTO = new UserDTO();
		if(userEntity != null){
			BeanCommonUtils.copyProperties(userEntity, userDTO);
			return userDTO;
		}else{
			return null;
		}
	}

}
