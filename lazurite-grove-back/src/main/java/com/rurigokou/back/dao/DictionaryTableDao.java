package com.rurigokou.back.dao;

import com.rurigokou.back.entity.DictionaryTableEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 字典表
 * 
 * @author gokoururi
 * @email rurigokou934164246@gmail.com
 * @date 2023-03-29 00:50:48
 */
@Mapper
public interface DictionaryTableDao extends BaseMapper<DictionaryTableEntity> {
	
}
