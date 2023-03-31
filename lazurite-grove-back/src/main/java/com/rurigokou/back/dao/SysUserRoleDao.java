package com.rurigokou.back.dao;

import com.rurigokou.back.entity.SysUserRoleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户角色表
 * 
 * @author gokoururi
 */
@Mapper
public interface SysUserRoleDao extends BaseMapper<SysUserRoleEntity> {
	
}
