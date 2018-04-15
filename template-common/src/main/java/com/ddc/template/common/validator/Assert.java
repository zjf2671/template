package com.ddc.template.common.validator;

import org.apache.commons.lang.StringUtils;

import com.ddc.template.common.exception.BusinessException;

/**
 * 数据校验
 * @author harry.zhang
 * 
 */
public abstract class Assert {

    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new BusinessException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new BusinessException(message);
        }
    }
}
