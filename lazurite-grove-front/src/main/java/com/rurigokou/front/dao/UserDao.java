package com.rurigokou.front.dao;

import com.rurigokou.front.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * 用户表
 * 
 * @author gokoururi
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

    @Update("update user set fan_num=fan_num+#{num} where id=#{id} and del=1")
    Boolean updateFanNum(@Param("id") Integer id, @Param("num") Integer num);

    @Update("update user set follow_num=follow_num+#{num} where id=#{id} and del=1")
    Boolean updateFollowNum(@Param("id") Integer id, @Param("num") Integer num);
}
