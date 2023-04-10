package com.rurigokou.back.controller;

import java.util.Arrays;
import java.util.Map;

import com.rurigokou.back.pagination.UserPage;
import org.springframework.web.bind.annotation.*;

import com.rurigokou.back.entity.UserEntity;
import com.rurigokou.back.service.UserService;
import com.rurigokou.common.dto.RuriPage;

import javax.annotation.Resource;



/**
 * 用户表
 *
 * @author gokoururi
 */
@RestController
@RequestMapping("back/user")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @PostMapping("/page")
    public RuriPage list(@RequestBody UserPage page) {
        return userService.queryPage(page);
    }

    @GetMapping("/info/{id}")
    public UserEntity info(@PathVariable("id") Integer id) {
        return userService.getById(id);
    }

    @PostMapping("/saveOrUpdate")
    public Boolean save(@RequestBody UserEntity user) {
        return userService.saveOrUpdate(user);
    }

    @PostMapping("/delete")
    public Boolean delete(@RequestBody Integer[] ids) {
        return userService.removeByIds(Arrays.asList(ids));
    }
}
