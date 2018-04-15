package com.ddc.template.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ddc.template.modules.sys.entity.SysCaptchaEntity;

import org.apache.ibatis.annotations.Mapper;

/**
 * 验证码
 *
 * @author harry.zhang
 */
@Mapper
public interface SysCaptchaDao extends BaseMapper<SysCaptchaEntity> {

}
