package com.rurigokou.back.article.dao;

import com.rurigokou.back.article.entity.ArticleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文章
 * 
 * @author gokoururi
 */
@Mapper
public interface ArticleDao extends BaseMapper<ArticleEntity> {
	
}
