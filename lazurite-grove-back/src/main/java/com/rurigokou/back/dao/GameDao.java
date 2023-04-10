package com.rurigokou.back.dao;

import com.rurigokou.back.entity.GameEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 游戏表
 * 
 * @author gokoururi
 */
@Mapper
public interface GameDao extends BaseMapper<GameEntity> {

}
