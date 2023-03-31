package com.rurigokou.back.dao;

import com.rurigokou.back.entity.GameTagEntity;
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
