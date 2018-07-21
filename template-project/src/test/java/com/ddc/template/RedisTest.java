package com.ddc.template;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ddc.template.common.utils.RedisUtils;
import com.ddc.template.modules.sys.entity.SysUserEntity;

public class RedisTest extends BaseSpringBootTest{
	@Autowired
	private RedisUtils redisUtils;

	@Test
	public void contextLoads() {
		SysUserEntity user = new SysUserEntity();
		user.setEmail("qqq@qq.com");
		redisUtils.set("user", user);

		System.out.println(ToStringBuilder.reflectionToString(redisUtils.get("user", SysUserEntity.class)));
	}

}
