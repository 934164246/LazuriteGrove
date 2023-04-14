package com.rurigokou.back.game.dao;

import com.rurigokou.back.game.entity.TagGameRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 游戏标签联系表
 * 
 * @author gokoururi
 */
@Mapper
public interface TagGameRelationDao extends BaseMapper<TagGameRelationEntity> {
	
}
