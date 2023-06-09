package com.rurigokou.back.game.dao;

import com.rurigokou.back.game.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表
 * 
 * @author gokoururi
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
	
}
