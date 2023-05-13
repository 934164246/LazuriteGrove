package com.rurigokou.front.controller;

import com.rurigokou.front.dto.UserInfoDto;
import com.rurigokou.front.dto.UserLoginDto;
import com.rurigokou.front.dto.UserRegisterDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.rurigokou.front.service.UserService;

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

    @PostMapping("/register")
    public String register(@Validated @RequestBody UserRegisterDto dto) {
        return userService.register(dto.getEmail(), dto.getPassword());
    }
}
