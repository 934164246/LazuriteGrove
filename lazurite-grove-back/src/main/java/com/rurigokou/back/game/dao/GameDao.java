package com.rurigokou.back.game.dao;

import com.rurigokou.back.game.entity.GameEntity;
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
