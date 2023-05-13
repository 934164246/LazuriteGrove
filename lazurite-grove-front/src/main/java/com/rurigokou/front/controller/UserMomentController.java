package com.rurigokou.front.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.rurigokou.common.dto.JwtTokenDto;
import com.rurigokou.common.utils.JwtUtils;
import com.rurigokou.front.dto.UserMomentDto;
import com.rurigokou.front.service.UserService;
import org.springframework.web.bind.annotation.*;

import com.rurigokou.front.entity.UserMomentEntity;
import com.rurigokou.front.service.UserMomentService;
import com.rurigokou.common.dto.RuriPage;

import javax.annotation.Resource;



/**
 * 用户动态表
 *
 * @author gokoururi
 */
@RestController
@RequestMapping("front/usermoment")
public class UserMomentController {

    @Resource(name = "userMomentService")
    private UserMomentService userMomentService;

    @GetMapping("/list")
    public List<UserMomentDto> page(@RequestHeader("Authorization") String token) {
        JwtTokenDto dto = JwtUtils.parseToken(token);

        return userMomentService.page(dto.getId());
    }

    @PostMapping("save")
    public Boolean page(@RequestBody UserMomentEntity entity) {
        return  userMomentService.save(entity);
    }

}
