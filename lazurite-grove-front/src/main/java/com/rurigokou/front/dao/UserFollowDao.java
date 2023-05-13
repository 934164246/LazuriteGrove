package com.rurigokou.front.dao;

import com.rurigokou.front.entity.UserFollowEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户订阅表
 * 
 * @author gokoururi
 */
@Mapper
public interface UserFollowDao extends BaseMapper<UserFollowEntity> {
	
}
