package com.rurigokou.back.article.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.rurigokou.back.article.entity.ArticleEntity;
import com.rurigokou.back.article.service.ArticleService;
import com.rurigokou.common.dto.RuriPage;

import javax.annotation.Resource;



/**
 * 文章
 *
 * @author gokoururi
 */
@RestController
@RequestMapping("back/article")
public class ArticleController {

    @Resource(name = "articleService")
    private ArticleService articleService;

    @PostMapping("/page")
    public RuriPage list(@RequestBody Map<String, Object> params){
        return articleService.queryPage(params);
    }

    @GetMapping("/info/{uid}")
    public ArticleEntity info(@PathVariable("uid") String uid){
		return articleService.getById(uid);
    }

    @PostMapping("/saveOrUpdate")
    public Boolean save(@RequestBody ArticleEntity article){
		return articleService.saveOrUpdate(article);
    }

    @PostMapping("/delete")
    public Boolean delete(@RequestBody String[] uids){
		return articleService.removeByIds(Arrays.asList(uids));
    }

}
