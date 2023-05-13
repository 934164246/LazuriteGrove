package com.rurigokou.front.controller;

import java.util.Arrays;
import java.util.Map;

import com.rurigokou.common.dto.JwtTokenDto;
import com.rurigokou.common.utils.JwtUtils;
import org.springframework.web.bind.annotation.*;

import com.rurigokou.front.entity.UserFollowEntity;
import com.rurigokou.front.service.UserFollowService;
import com.rurigokou.common.dto.RuriPage;

import javax.annotation.Resource;



/**
 * 用户订阅表
 *
 * @author gokoururi
 */
@RestController
@RequestMapping("front/follow")
public class UserFollowController {

    @Resource(name = "userFollowService")
    private UserFollowService userFollowService;

    @PostMapping("/followUser/{userId}")
    public Boolean follow(@PathVariable("userId") Integer userId, @RequestHeader("Authorization") String token) {
        JwtTokenDto dto = JwtUtils.parseToken(token);

        return userFollowService.follow(userId, dto.getId());
    }

    @PostMapping("/notFollow/{userId}")
    public Boolean notFollow(@PathVariable("userId") Integer userId, @RequestHeader("Authorization") String token) {
        JwtTokenDto dto = JwtUtils.parseToken(token);

        return userFollowService.notFollow(userId, dto.getId());
    }

    @GetMapping("isFollow")
    private Boolean isFollow(@RequestParam("user") Integer user, @RequestParam("follow") Integer follow) {
        return userFollowService.checkUserFollow(follow, user);
    }
}
