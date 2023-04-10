package com.rurigokou.back.service;

import com.rurigokou.back.pagination.UserPage;
import com.rurigokou.common.dto.RuriPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.back.entity.UserEntity;

import java.util.Map;

/**
 * 用户表
 *
 * @author gokoururi
 */
public interface UserService extends IService<UserEntity> {

    RuriPage queryPage(UserPage page);

    String login(String username, String password);

    boolean saveOrUpdate(UserEntity entity);
}

