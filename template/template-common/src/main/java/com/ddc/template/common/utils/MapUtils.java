package com.ddc.template.common.utils;

import java.util.HashMap;


/**
 * Map工具类
 *
 * @author harry.zhang
 */
public class MapUtils extends HashMap<String, Object> {

	private static final long serialVersionUID = 1L;

	@Override
    public MapUtils put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
