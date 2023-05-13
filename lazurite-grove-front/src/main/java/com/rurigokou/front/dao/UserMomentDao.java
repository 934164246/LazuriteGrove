package com.rurigokou.front.dao;

import com.rurigokou.front.entity.ArticleEntity;
import com.rurigokou.front.entity.UserMomentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户动态表
 * 
 * @author gokoururi
 */
@Mapper
public interface UserMomentDao extends BaseMapper<UserMomentEntity> {

    @Select("select *\n" +
            "from user_moment as moment join\n" +
            "    (select follow_id from user_follow where user_id=#{userId} and del=1) as follow\n" +
            "    on moment.user_id=follow.follow_id\n" +
            "where\n" +
            "    moment.del='1'")
    List<UserMomentEntity> selectMoment(@Param("userId") Integer userId);

    @Select("select *\n" +
            "from article join\n" +
            "    (select follow_id from user_follow where user_id=#{userId} and del=1) as follow\n" +
            "    on article.user_id=follow.follow_id\n" +
            "where\n" +
            "    article.del='1';")
    List<ArticleEntity> getArticle(@Param("userId") Integer userId);
}
