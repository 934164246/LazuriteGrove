package com.rurigokou.front.dao;

import com.rurigokou.front.dto.ArticleRankDto;
import com.rurigokou.front.entity.ArticleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 文章
 * 
 * @author gokoururi
 */
@Mapper
public interface ArticleDao extends BaseMapper<ArticleEntity> {

    List<ArticleRankDto> getArticle();
}
