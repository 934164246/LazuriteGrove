package com.rurigokou.back.article.dao;

import com.rurigokou.back.article.entity.UserCommentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户评论表
 * 
 * @author gokoururi
 */
@Mapper
public interface UserCommentDao extends BaseMapper<UserCommentEntity> {
	
}
