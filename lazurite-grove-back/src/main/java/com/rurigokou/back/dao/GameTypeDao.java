package com.rurigokou.back.dao;

import com.rurigokou.back.entity.GameTypeEntity;
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
