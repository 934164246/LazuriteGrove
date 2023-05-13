package com.rurigokou.front.service;

import com.rurigokou.common.dto.RuriPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.front.entity.UserFollowEntity;

import java.util.Map;

/**
 * 用户订阅表
 *
 * @author gokoururi
 */
public interface UserFollowService extends IService<UserFollowEntity> {

    RuriPage queryPage(Map<String, Object> params);

    Boolean checkUserFollow(Integer upId, Integer userId);

    Boolean follow(Integer upId, Integer userId);

    Boolean notFollow(Integer upId, Integer userId);
}

