package com.rurigokou.front.service;

import com.rurigokou.common.dto.RuriPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.front.dto.UserInfoDto;
import com.rurigokou.front.entity.UserEntity;

import java.util.Map;

/**
 * 用户表
 *
 * @author gokoururi
 */
public interface UserService extends IService<UserEntity> {

    /**
     * 用户登录
     *
     * @param username 账号
     * @param password 密码
     * @return 返回token
     */
    String login(String username, String password);

    UserInfoDto info(String id);

    String register(String email, String password);

    Boolean fanCountIncrease(Integer id, Integer count);

    Boolean followCountChange(Integer id, Integer count);
}

