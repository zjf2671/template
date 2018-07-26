package com.ddc.template.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisCommands;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Redis分布式锁
 * @author harry.zhang
 * @date 2018年7月24日下午4:15:21
 */
@Component
public class RedisDistributedLock {

	private final Logger logger = LoggerFactory.getLogger(RedisDistributedLock.class);

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	public static final String UNLOCK_LUA;

	private static final String TIMEUNIT = "EX"; //EX = seconds  //PX = milliseconds

	private static final String SET_IF_NOT_EXIST = "NX";

	public static ThreadLocal<String> lockFlag = new ThreadLocal<String>();

	static {
		StringBuilder sb = new StringBuilder();
		sb.append("if redis.call(\"get\",KEYS[1]) == ARGV[1] ");
		sb.append("then ");
		sb.append("    return redis.call(\"del\",KEYS[1]) ");
		sb.append("else ");
		sb.append("    return 0 ");
		sb.append("end ");
		UNLOCK_LUA = sb.toString();
	}

	public boolean acquireLock(String key, long expire) {
		try {
			RedisCallback<String> callback = (connection) -> {
				JedisCommands commands = (JedisCommands) connection.getNativeConnection();
				String uuid = UUID.randomUUID().toString();
				lockFlag.set(uuid);
				return commands.set(key, uuid, SET_IF_NOT_EXIST, TIMEUNIT, expire);
			};
			String result = redisTemplate.execute(callback);
			System.out.println("------------"+result);
			return !StringUtils.isEmpty(result);

		} catch (Exception e) {
			logger.error("set redis occured an exception", e);
		}
		return false;
	}

	public boolean releaseLock(String key) {
		// 释放锁的时候，有可能因为持锁之后方法执行时间大于锁的有效期，此时有可能已经被另外一个线程持有锁，所以不能直接删除
		try {
			String requestId = lockFlag.get();
			List<String> keys = new ArrayList<>();
			keys.add(key);
			List<String> args = new ArrayList<>();
			args.add(requestId);
			// 使用lua脚本删除redis中匹配value的key，可以避免由于方法执行时间过长而redis锁自动过期失效的时候误删其他线程的锁
			// spring自带的执行脚本方法中，集群模式直接抛出不支持执行脚本的异常，所以只能拿到原redis的connection来执行脚本
			RedisCallback<Long> callback = (connection) -> {
				Object nativeConnection = connection.getNativeConnection();
				// 集群模式和单机模式虽然执行脚本的方法一样，但是没有共同的接口，所以只能分开执行
				// 集群模式
				if (nativeConnection instanceof JedisCluster) {
					return (Long) ((JedisCluster) nativeConnection).eval(UNLOCK_LUA, keys, args);
				}
				// 单机模式
				else if (nativeConnection instanceof Jedis) {
					return (Long) ((Jedis) nativeConnection).eval(UNLOCK_LUA, keys, args);
				}
				return 0L;

			};
			Long result = redisTemplate.execute(callback);
			return result != null && result > 0;
		} catch (Exception e) {
			logger.error("release lock occured an exception", e);

		} finally {
			// 清除掉ThreadLocal中的数据，避免内存溢出
			lockFlag.remove();
		}
		return false;
	}
	

	public String get(String key) {
		try {
			RedisCallback<String> callback = (connection) -> {
				JedisCommands commands = (JedisCommands) connection.getNativeConnection();
				return commands.get(key);
			};
			String result = redisTemplate.execute(callback);
			return result;

		} catch (Exception e) {
			logger.error("get redis occured an exception", e);
		}

		return "";

	}

}