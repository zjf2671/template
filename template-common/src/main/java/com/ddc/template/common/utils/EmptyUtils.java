package com.ddc.template.common.utils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * 判空工具类
 * @author harry.zhang
 * @date 2018年7月5日下午2:53:31
 */
public class EmptyUtils {

    private EmptyUtils() {
        throw new UnsupportedOperationException("");
    }

    /**
     * 判断对象是否为空
     * @param obj 对象
     * @return true: 为空 false: 不为空
     */
    @SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof String && obj.toString().length() == 0) {
            return true;
        }
        if (obj.getClass().isArray() && Array.getLength(obj) == 0) {
            return true;
        }
        if (obj instanceof Collection && ((Collection) obj).isEmpty()) {
            return true;
        }
        if (obj instanceof Map && ((Map) obj).isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 判断对象是否非空
     * @param  obj 对象
     * @return true: 非空  false: 空
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

}
