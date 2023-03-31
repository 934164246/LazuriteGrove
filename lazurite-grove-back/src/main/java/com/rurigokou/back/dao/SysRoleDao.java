package com.rurigokou.back.dao;

import com.rurigokou.back.entity.SysRoleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统角色表
 * 
 * @author gokoururi
 */
@Mapper
public interface SysRoleDao extends BaseMapper<SysRoleEntity> {
	
}
