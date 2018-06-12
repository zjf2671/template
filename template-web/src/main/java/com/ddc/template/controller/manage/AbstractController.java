package com.ddc.template.controller.manage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ddc.template.common.util.RedisKeys;
import com.ddc.template.common.utils.RedisUtils;
import com.ddc.template.vo.SysUserVO;

/**
 * Controller公共组件
 * 
 * @author harry.zhang
 * 
 */
public abstract class AbstractController {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	public HttpServletRequest request;

	@Resource
	public HttpServletResponse response;
	
	@Resource
	private RedisUtils redisUtils;

	protected SysUserVO getUser() {
		return redisUtils.get(RedisKeys.getSessionKey(request.getAttribute("userId").toString()), SysUserVO.class);
	}

	protected Integer getUserId() {
		return getUser().getUserId();
	}
}
