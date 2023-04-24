package com.rurigokou.front.controller;

import java.util.Arrays;
import java.util.Map;

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

    @PostMapping("/page")
    public RuriPage list(@RequestBody Map<String, Object> params){
        return articleContentService.queryPage(params);
    }

    @GetMapping("/info/{articleid}")
    public ArticleContentEntity info(@PathVariable("articleid") Integer articleid){
		return articleContentService.getById(articleid);
    }

    @PostMapping("/saveOrUpdate")
    public Boolean save(@RequestBody ArticleContentEntity articleContent){
		return articleContentService.saveOrUpdate(articleContent);
    }

    @PostMapping("/delete")
    public Boolean delete(@RequestBody Integer[] articleids){
		return articleContentService.removeByIds(Arrays.asList(articleids));
    }

}
