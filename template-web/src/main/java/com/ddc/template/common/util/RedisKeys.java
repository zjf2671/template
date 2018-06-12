package com.ddc.template.common.util;

/**
 * Redis所有Keys
 *
 * @author harry.zhang
 * 
 */
public class RedisKeys {

    public static String getSysConfigKey(String key){
        return "sys:config:" + key;
    }
    
    public static String getSessionKey(String key){
        return "sessionid:store:" + key;
    }
}
