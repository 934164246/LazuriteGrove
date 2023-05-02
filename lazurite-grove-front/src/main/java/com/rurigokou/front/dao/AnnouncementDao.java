package com.rurigokou.front.dao;

import com.rurigokou.front.entity.AnnouncementEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 公告表
 * 
 * @author gokoururi
 */
@Mapper
public interface AnnouncementDao extends BaseMapper<AnnouncementEntity> {
	
}
