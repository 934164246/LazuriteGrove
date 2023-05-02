package com.rurigokou.front.controller;

import java.util.Arrays;
import java.util.Map;

import com.rurigokou.common.dto.JwtTokenDto;
import com.rurigokou.common.utils.JwtUtils;
import org.springframework.web.bind.annotation.*;

import com.rurigokou.front.entity.ArticleContentEntity;
import com.rurigokou.front.service.ArticleContentService;
import com.rurigokou.common.dto.RuriPage;

import javax.annotation.Resource;



/**
 * 文章内容表
 *
 * @author gokoururi
 */
@RestController
@RequestMapping("front/articlecontent")
public class ArticleContentController {

    @Resource(name = "articleContentService")
    private ArticleContentService articleContentService;

    @GetMapping("/info/{articleId}")
    public ArticleContentEntity info(@PathVariable("articleId") String articleId){
		return articleContentService.getById(articleId);
    }

    @PostMapping("/saveOrUpdate")
    public Boolean save(@RequestBody ArticleContentEntity articleContent, @RequestHeader("Authorization") String token) {
        JwtTokenDto dto = JwtUtils.parseToken(token);
        Integer id = dto.getId();

        return articleContentService.saveOrUpdate(articleContent);
    }

    @PostMapping("/delete")
    public Boolean delete(@RequestBody Integer[] ids){
		return articleContentService.removeByIds(Arrays.asList(ids));
    }

}
