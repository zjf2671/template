package com.ddc.template.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ddc.template.modules.sys.entity.SysDeptEntity;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 部门管理
 * 
 * @author harry.zhang
 */
@Mapper
public interface SysDeptDao extends BaseMapper<SysDeptEntity> {

    /**
     * 查询子部门ID列表
     * @param parentId  上级部门ID
     */
    List<Long> queryDetpIdList(Long parentId);

}
