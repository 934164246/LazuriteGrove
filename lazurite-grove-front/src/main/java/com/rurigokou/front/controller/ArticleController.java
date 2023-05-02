package com.rurigokou.front.controller;

import java.util.List;

import com.rurigokou.common.dto.JwtTokenDto;
import com.rurigokou.common.utils.JwtUtils;
import com.rurigokou.front.dto.ArticleDto;
import com.rurigokou.front.dto.ArticleRankDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import com.rurigokou.front.service.ArticleService;

import javax.annotation.Resource;



/**
 * 文章
 *
 * @author gokoururi
 */
@Slf4j
@RestController
@RequestMapping("front/article")
public class ArticleController {

    @Resource(name = "articleService")
    private ArticleService articleService;

    @GetMapping("/top")
    public List<ArticleRankDto> getTop() {
        return articleService.getTop();
    }

    @GetMapping("/recent")
    public List<ArticleRankDto> getRecent() {
        return articleService.getRecent();
    }

    @PostMapping("/save")
    public Boolean saveAsNormal(@RequestBody ArticleDto dto, @RequestHeader("Authorization") String token) {
        JwtTokenDto userInfo = JwtUtils.parseToken(token);

        dto.setUserId(userInfo.getId());
        dto.setStatus(1);

        return articleService.save(dto);
    }

    @PostMapping("/saveAsDraft")
    public Boolean saveAsDraft(@RequestBody ArticleDto dto, @RequestHeader("Authorization") String token) {

        JwtTokenDto userInfo = JwtUtils.parseToken(token);

        dto.setUserId(userInfo.getId());
        dto.setStatus(2);


        return articleService.save(dto);
    }

    @GetMapping("getDrafts")
    public List<ArticleDto> getDraftsByUser(@RequestHeader("Authorization") String token) {
        JwtTokenDto userInfo = JwtUtils.parseToken(token);

        return articleService.getDrafts(userInfo.getId());
    }

    @GetMapping("getDraft/{uid}")
    public ArticleDto getDraft(@PathVariable("uid") String uid) {

        return articleService.getDraft(uid);
    }

    @PostMapping("deleteArticle/{uid}")
    public Boolean deleteArticle(@PathVariable("uid") String uid) {
        return articleService.deleteArticle(uid);
    }
}
