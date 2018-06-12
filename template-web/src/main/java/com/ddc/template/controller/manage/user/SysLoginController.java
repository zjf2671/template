package com.ddc.template.controller.manage.user;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ddc.template.common.util.JwtUtils;
import com.ddc.template.common.util.RedisKeys;
import com.ddc.template.common.utils.R;
import com.ddc.template.common.utils.RedisUtils;
import com.ddc.template.common.validator.ValidatorUtils;
import com.ddc.template.common.validator.group.Group;
import com.ddc.template.manage.user.SysUserManage;
import com.ddc.template.vo.SysLoginForm;
import com.ddc.template.vo.SysUserVO;


/**
 * 登录相关
 * 
 * @author harry.zhang
 * 
 */
@RestController
public class SysLoginController {
	@Autowired
    private JwtUtils jwtUtils;
	@Autowired
	private SysUserManage userManage;
	@Autowired
	private RedisUtils redisUtils;

	/**
	 * 登录
	 */
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody SysLoginForm form)throws IOException {
		ValidatorUtils.validateEntity(form, Group.class);
		SysUserVO user = userManage.login(form.getUsername(), form.getPassword(), form.getShopId());

		//账号不存在、密码错误
		if(user.getUserId() == null) {
			return R.error("账号或密码不正确");
		}
		
		//生成token
        String token = jwtUtils.generateToken(form.getPlatform()+user.getUserId());

        R r = R.ok().put("token", token).put("expire", jwtUtils.getExpire()).put("sysUser", user);
        
        //把用户信息存到redis中设置和token同样的过期时间
        redisUtils.set(RedisKeys.getSessionKey(form.getPlatform()+user.getUserId()), user, jwtUtils.getExpire());
		return r;
	}


	/**
	 * 退出
	 */
//	@PostMapping("/logout")
//	public R logout() {
//		sysUserTokenService.logout(getUserId());
//		return R.ok();
//	}
	
}
