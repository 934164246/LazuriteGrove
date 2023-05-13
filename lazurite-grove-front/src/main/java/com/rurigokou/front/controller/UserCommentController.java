package com.rurigokou.front.controller;

import java.util.Arrays;
import java.util.Map;

import com.rurigokou.front.dto.UserCommentDto;
import com.rurigokou.front.pagination.UserCommentPage;
import org.springframework.web.bind.annotation.*;

import com.rurigokou.front.entity.UserCommentEntity;
import com.rurigokou.front.service.UserCommentService;
import com.rurigokou.common.dto.RuriPage;

import javax.annotation.Resource;



/**
 * 用户评论表
 *
 * @author gokoururi
 */
@RestController
@RequestMapping("front/comment")
public class UserCommentController {

    @Resource(name = "userCommentService")
    private UserCommentService userCommentService;

    @PostMapping("saveFromArticle")
    public Boolean saveFromArticle(@RequestBody UserCommentDto dto) {
        return userCommentService.saveAsArticle(dto);
    }

    @GetMapping("/pageOfArticle")
    public RuriPage pageOfArticle(@ModelAttribute UserCommentPage page){
        return userCommentService.page(page, "1");
    }

    @PostMapping("saveFromMoment")
    public Boolean saveFromMoment(@RequestBody UserCommentDto dto) {
        return userCommentService.saveAsMoment(dto);
    }

    @GetMapping("pageOfMoment")
    public RuriPage pageOfMoment(@ModelAttribute UserCommentPage page) {
        return userCommentService.page(page, "2");
    }
}
