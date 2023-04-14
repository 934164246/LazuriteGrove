package com.rurigokou.back.game.dao;

import com.rurigokou.back.game.entity.TypeGameRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 游戏类型联系表
 * 
 * @author gokoururi
 */
@Mapper
public interface TypeGameRelationDao extends BaseMapper<TypeGameRelationEntity> {
	
}
