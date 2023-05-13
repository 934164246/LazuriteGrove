package com.rurigokou.front.dao;

import com.rurigokou.front.dto.ArticleRankDto;
import com.rurigokou.front.entity.ArticleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 文章
 * 
 * @author gokoururi
 */
@Mapper
public interface ArticleDao extends BaseMapper<ArticleEntity> {

    List<ArticleRankDto> getArticle();

    Boolean updateReadNum(@Param("id") String id);

    Boolean updateLikeNum(@Param("id") String id);

    Boolean updateCommentNum(@Param("id") String id);

    @Select("select count(1) from article where user_id=#{userId} and del='1'")
    Integer selectArticleNumByUserId(@Param("userId") Integer userId);
}
