package com.ddc.template.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.ddc.template.common.utils.PageUtils;
import com.ddc.template.modules.sys.entity.SysRoleEntity;

import java.util.List;
import java.util.Map;


/**
 * 角色
 * 
 * @author harry.zhang
 * 
 */
public interface SysRoleService extends IService<SysRoleEntity> {

	PageUtils queryPage(Map<String, Object> params);

	void save(SysRoleEntity role);

	void update(SysRoleEntity role);

	void deleteBatch(Long[] roleIds);

	
	/**
	 * 查询用户创建的角色ID列表
	 */
	List<Long> queryRoleIdList(Long createUserId);
}
