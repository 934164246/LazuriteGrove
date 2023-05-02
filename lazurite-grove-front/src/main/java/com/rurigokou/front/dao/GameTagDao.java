package com.rurigokou.front.dao;

import com.rurigokou.front.entity.GameTagEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 游戏标签表
 * 
 * @author gokoururi
 */
@Mapper
public interface GameTagDao extends BaseMapper<GameTagEntity> {
	
}
