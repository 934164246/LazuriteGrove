package com.rurigokou.back.game.service;

import com.rurigokou.back.game.pagination.UserPage;
import com.rurigokou.common.dto.RuriPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.back.game.entity.UserEntity;

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

