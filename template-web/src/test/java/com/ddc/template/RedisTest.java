package com.ddc.template;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.ddc.template.common.utils.RedisUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
	@Autowired
	private RedisUtils redisUtils;

	@Test
	public void contextLoads() {
		Map<String, Object> log = new HashMap<>();
		log.put("test", 1);
		redisUtils.set("log", log);

		System.out.println(JSON.toJSONString((redisUtils.get("log", Map.class))));
	}

}
