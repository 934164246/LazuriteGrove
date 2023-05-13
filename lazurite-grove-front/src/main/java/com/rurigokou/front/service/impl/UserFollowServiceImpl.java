package com.rurigokou.front.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rurigokou.common.dto.RuriPage;
import com.rurigokou.front.entity.UserEntity;
import com.rurigokou.front.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.front.dao.UserFollowDao;
import com.rurigokou.front.entity.UserFollowEntity;
import com.rurigokou.front.service.UserFollowService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @author gokoururi
*/
@Service("userFollowService")
public class UserFollowServiceImpl extends ServiceImpl<UserFollowDao, UserFollowEntity> implements UserFollowService {

    @Resource(name = "userService")
    private UserService userService;

    @Override
    public RuriPage queryPage(Map<String, Object> params) {
        return new RuriPage();
    }

    @Override
    public Boolean checkUserFollow(Integer upId, Integer userId) {
        QueryWrapper<UserFollowEntity> wrapper=new QueryWrapper<>();
        wrapper.eq("user_id", userId)
                .eq("follow_id", upId);

        UserFollowEntity one = this.getOne(wrapper);

        return one != null;
    }

    @Override
    @Transactional
    public Boolean follow(Integer upId, Integer userId) {
        Boolean isFollow = checkUserFollow(upId, userId);

        if (isFollow) {
            return false;
        }

        UserFollowEntity entity=new UserFollowEntity();
        entity.setUserId(userId);
        entity.setFollowId(upId);
        entity.setFollowTime(new Date());

        if (!this.save(entity)) {
            return false;
        }

        userService.fanCountIncrease(upId, 1);
        userService.followCountChange(userId, 1);

        return true;
    }

    @Override
    @Transactional
    public Boolean notFollow(Integer upId, Integer userId) {
        QueryWrapper<UserFollowEntity> wrapper=new QueryWrapper<>();
        wrapper.eq("user_id", userId)
                .eq("follow_id", upId);

        if (!this.remove(wrapper)) {
            return false;
        }

        userService.fanCountIncrease(upId, -1);
        userService.followCountChange(userId, -1);

        return true;
    }
}