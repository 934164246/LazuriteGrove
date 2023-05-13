package com.rurigokou.front.service.impl;

import com.alibaba.nacos.common.utils.MD5Utils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rurigokou.common.dto.JwtTokenDto;
import com.rurigokou.common.dto.RuriPage;
import com.rurigokou.common.exception.RuriErrorCodeEnum;
import com.rurigokou.common.exception.RuriException;
import com.rurigokou.common.utils.JwtUtils;
import com.rurigokou.front.dto.UserInfoDto;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.front.dao.UserDao;
import com.rurigokou.front.entity.UserEntity;
import com.rurigokou.front.service.UserService;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;

/**
* @author gokoururi
*/
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public String login(String username, String password) {
        QueryWrapper<UserEntity> wrapper=new QueryWrapper<>();
        wrapper.eq("email", username);

        List<UserEntity> list = this.list(wrapper);
        if (CollectionUtils.isEmpty(list) || list.size() > 1) {
            throw new RuriException(RuriErrorCodeEnum.ACCOUNT_PASSWORD_EXCEPTION);
        }

        UserEntity entity=list.get(0);

        String encrypted = DigestUtils.md5DigestAsHex(password.getBytes()).toUpperCase();
        if (encrypted.equals(entity.getPassword())) {
            JwtTokenDto dto=new JwtTokenDto();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setIat(new Date());
            dto.setExp(60L);

            return JwtUtils.generateToken(dto);
        } else {
            throw new RuriException(RuriErrorCodeEnum.ACCOUNT_PASSWORD_EXCEPTION);
        }
    }

    @Override
    public UserInfoDto info(String id) {
        UserEntity entity = this.getById(id);

        return Objects.isNull(entity) ? new UserInfoDto() : UserInfoDto.toDto(entity);
    }

    @Override
    public String register(String email, String password) {
        QueryWrapper<UserEntity> wrapper=new QueryWrapper<>();
        wrapper.eq("email", email);

        UserEntity user = this.getOne(wrapper);

        //判断是否存在
        if (user != null) {
            throw new RuriException(RuriErrorCodeEnum.EMAIL_REPEAT_EXCEPTION);
        }

        UserEntity entity=new UserEntity();
        entity.setName("user");
        entity.setEmail(email);
        entity.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()).toUpperCase());
        entity.setHeadImg("https://gokoururi.oss-cn-shanghai.aliyuncs.com/img/2023/04/14/5b41253f5fb7442d8f44302397f75b96_head.jpg");

        this.save(entity);

        JwtTokenDto dto=new JwtTokenDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setIat(new Date());
        dto.setExp(60L);

        return JwtUtils.generateToken(dto);
    }

    @Override
    public Boolean fanCountIncrease(Integer id, Integer count) {
        return userDao.updateFanNum(id, count);
    }

    @Override
    public Boolean followCountChange(Integer id, Integer count) {
        return userDao.updateFollowNum(id, count);
    }
}