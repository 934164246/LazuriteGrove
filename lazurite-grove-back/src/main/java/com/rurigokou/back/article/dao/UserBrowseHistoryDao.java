package com.rurigokou.back.article.dao;

import com.rurigokou.back.article.entity.UserBrowseHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户浏览历史表
 * 
 * @author gokoururi
 */
@Mapper
public interface UserBrowseHistoryDao extends BaseMapper<UserBrowseHistoryEntity> {
	
}
