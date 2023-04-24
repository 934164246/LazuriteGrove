package com.rurigokou.front.dao;

import com.rurigokou.front.entity.ArticleContentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文章内容表
 * 
 * @author gokoururi
 */
@Mapper
public interface ArticleContentDao extends BaseMapper<ArticleContentEntity> {
	
}
