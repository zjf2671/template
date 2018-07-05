package com.ddc.template.common.utils;

import org.apache.commons.lang.RandomStringUtils;

/**
 * 随机数
 * @author harry.zhang
 * @date 2018年7月5日下午2:58:29
 */
public class RandomUtils {
	
	public static String getRandomNo(){
		return String.valueOf(System.currentTimeMillis()) + RandomStringUtils.randomNumeric(5);
	}
	
	public static void main(String[] args) {
		System.err.println(getRandomNo());
	}

}
