package com.rurigokou.front.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

import com.rurigokou.front.dto.UserInfoDto;
import com.rurigokou.front.dto.UserLoginDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.rurigokou.front.entity.UserEntity;
import com.rurigokou.front.service.UserService;
import com.rurigokou.common.dto.RuriPage;

import javax.annotation.Resource;



/**
 * 用户表
 *
 * @author gokoururi
 */
@RestController
@RequestMapping("front/user")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @PostMapping("login")
    public String login(@Validated @RequestBody UserLoginDto dto) {
        return userService.login(dto.getUsername(), dto.getPassword());
    }

    @GetMapping("info/{id}")
    public UserInfoDto getInfo(@PathVariable("id") String id) {

        return userService.info(id);
    }
}
