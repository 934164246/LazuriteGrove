package com.rurigokou.front.dao;

import com.rurigokou.front.entity.GameTypeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 游戏类型表
 * 
 * @author gokoururi
 */
@Mapper
public interface GameTypeDao extends BaseMapper<GameTypeEntity> {
	
}
