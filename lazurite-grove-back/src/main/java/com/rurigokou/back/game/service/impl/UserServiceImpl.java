package com.rurigokou.back.game.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rurigokou.back.game.pagination.UserPage;
import com.rurigokou.common.dto.RuriPage;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.back.game.dao.UserDao;
import com.rurigokou.back.game.entity.UserEntity;
import com.rurigokou.back.game.service.UserService;

/**
* @author gokoururi
*/
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public RuriPage queryPage(UserPage page) {
        QueryWrapper<UserEntity> wrapper=new QueryWrapper<>();

        return new RuriPage();
    }

    @Override
    public String login(String username, String password) {


        return null;
    }

    @Override
    public boolean saveOrUpdate(UserEntity entity) {
        String password = entity.getPassword();


        return false;
    }

}