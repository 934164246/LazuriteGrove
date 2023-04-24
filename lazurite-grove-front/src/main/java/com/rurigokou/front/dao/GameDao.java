package com.rurigokou.front.dao;

import com.rurigokou.front.entity.GameEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 游戏表
 * 
 * @author gokoururi
 */
@Mapper
public interface GameDao extends BaseMapper<GameEntity> {
	
}
