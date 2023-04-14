package com.rurigokou.back.article.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.rurigokou.back.article.entity.UserArticleEntity;
import com.rurigokou.back.article.service.UserArticleService;
import com.rurigokou.common.dto.RuriPage;

import javax.annotation.Resource;



/**
 * 用户文章表
 *
 * @author gokoururi
 */
@RestController
@RequestMapping("back/userarticle")
public class UserArticleController {

    @Resource(name = "userArticleService")
    private UserArticleService userArticleService;

    @PostMapping("/page")
    public RuriPage list(@RequestBody Map<String, Object> params){
        return userArticleService.queryPage(params);
    }

    @GetMapping("/info/{id}")
    public UserArticleEntity info(@PathVariable("id") Integer id){
		return userArticleService.getById(id);
    }

    @PostMapping("/saveOrUpdate")
    public Boolean save(@RequestBody UserArticleEntity userArticle){
		return userArticleService.saveOrUpdate(userArticle);
    }

    @PostMapping("/delete")
    public Boolean delete(@RequestBody Integer[] ids){
		return userArticleService.removeByIds(Arrays.asList(ids));
    }

}
