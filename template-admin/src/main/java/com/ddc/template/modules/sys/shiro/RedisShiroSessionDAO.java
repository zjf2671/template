package com.ddc.template.modules.sys.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;

import com.ddc.template.common.utils.RedisKeys;

import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * shiro session dao
 *
 * @author harry.zhang
 */
@Component
@SuppressWarnings("unchecked")
public class RedisShiroSessionDAO extends EnterpriseCacheSessionDAO {

    Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
    JdkSerializationRedisSerializer jdkSerializationRedisSerializer = new JdkSerializationRedisSerializer();

	@SuppressWarnings("rawtypes")
	@Autowired
    private RedisTemplate redisTemplate;

    //创建session
    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = super.doCreate(session);
        final String key = RedisKeys.getShiroSessionKey(sessionId.toString());
        setShiroSession(key, session);
        return sessionId;
    }

    //获取session
    @Override
    protected Session doReadSession(Serializable sessionId) {
        Session session = super.doReadSession(sessionId);
        if(session == null){
            final String key = RedisKeys.getShiroSessionKey(sessionId.toString());
            session = getShiroSession(key);
        }
        return session;
    }

    //更新session
    @Override
    protected void doUpdate(Session session) {
        super.doUpdate(session);
        final String key = RedisKeys.getShiroSessionKey(session.getId().toString());
        setShiroSession(key, session);
    }

    //删除session
	@Override
    protected void doDelete(Session session) {
        super.doDelete(session);
        final String key = RedisKeys.getShiroSessionKey(session.getId().toString());
        redisTemplate.delete(key);
    }

    private Session getShiroSession(String key) {
        //用jdk序列化(为了解决用jackson2JsonRedisSerializer序列化session的问题)
        redisTemplate.setValueSerializer(jdkSerializationRedisSerializer);

        Session session = (Session)redisTemplate.opsForValue().get(key);
        //复原
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        return session;
    }

    private void setShiroSession(String key, Session session){

        //用jdk序列化(为了解决用jackson2JsonRedisSerializer序列化session的问题)
        redisTemplate.setValueSerializer(jdkSerializationRedisSerializer);

        redisTemplate.opsForValue().set(key, session);
        //60分钟过期
        redisTemplate.expire(key, 60, TimeUnit.MINUTES);

        //复原
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
    }

}
