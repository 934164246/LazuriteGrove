package com.rurigokou.back.dao;

import com.rurigokou.back.entity.TagGameRelationEntity;
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
