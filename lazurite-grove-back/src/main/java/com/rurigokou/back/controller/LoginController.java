package com.rurigokou.back.controller;

import com.rurigokou.back.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author gokoururi
 */
@RestController
@RequestMapping("back")
public class LoginController {

    @Resource(name = "userService")
    private UserService userService;

    @PostMapping("login")
    public String login() {
        return null;
    }

    @PostMapping("logout/{id}")
    public void logout(@PathVariable("id") Integer id) {

    }
}
