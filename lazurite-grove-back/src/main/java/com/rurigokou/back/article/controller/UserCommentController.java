package com.rurigokou.back.article.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.rurigokou.back.article.entity.UserCommentEntity;
import com.rurigokou.back.article.service.UserCommentService;
import com.rurigokou.common.dto.RuriPage;

import javax.annotation.Resource;



/**
 * 用户评论表
 *
 * @author gokoururi
 */
@RestController
@RequestMapping("back/usercomment")
public class UserCommentController {

    @Resource(name = "userCommentService")
    private UserCommentService userCommentService;

    @PostMapping("/page")
    public RuriPage list(@RequestBody Map<String, Object> params){
        return userCommentService.queryPage(params);
    }

    @GetMapping("/info/{uid}")
    public UserCommentEntity info(@PathVariable("uid") String uid){
		return userCommentService.getById(uid);
    }

    @PostMapping("/saveOrUpdate")
    public Boolean save(@RequestBody UserCommentEntity userComment){
		return userCommentService.saveOrUpdate(userComment);
    }

    @PostMapping("/delete")
    public Boolean delete(@RequestBody String[] uids){
		return userCommentService.removeByIds(Arrays.asList(uids));
    }

}
