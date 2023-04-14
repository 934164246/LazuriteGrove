package com.rurigokou.back.article.dao;

import com.rurigokou.back.article.entity.UserArticleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户文章表
 * 
 * @author gokoururi
 */
@Mapper
public interface UserArticleDao extends BaseMapper<UserArticleEntity> {
	
}
