package com.rurigokou.back.article.dao;

import com.rurigokou.back.article.entity.ArticleUserHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文章资源用户获取表
 * 
 * @author gokoururi
 */
@Mapper
public interface ArticleUserHistoryDao extends BaseMapper<ArticleUserHistoryEntity> {
	
}
