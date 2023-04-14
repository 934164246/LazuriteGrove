package com.rurigokou.back.article.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.rurigokou.back.article.entity.ArticleUserHistoryEntity;
import com.rurigokou.back.article.service.ArticleUserHistoryService;
import com.rurigokou.common.dto.RuriPage;

import javax.annotation.Resource;



/**
 * 文章资源用户获取表
 *
 * @author gokoururi
 */
@RestController
@RequestMapping("back/articleuserhistory")
public class ArticleUserHistoryController {

    @Resource(name = "articleUserHistoryService")
    private ArticleUserHistoryService articleUserHistoryService;

    @PostMapping("/page")
    public RuriPage list(@RequestBody Map<String, Object> params){
        return articleUserHistoryService.queryPage(params);
    }

    @GetMapping("/info/{articleid}")
    public ArticleUserHistoryEntity info(@PathVariable("articleid") Integer articleid){
		return articleUserHistoryService.getById(articleid);
    }

    @PostMapping("/saveOrUpdate")
    public Boolean save(@RequestBody ArticleUserHistoryEntity articleUserHistory){
		return articleUserHistoryService.saveOrUpdate(articleUserHistory);
    }

    @PostMapping("/delete")
    public Boolean delete(@RequestBody Integer[] articleids){
		return articleUserHistoryService.removeByIds(Arrays.asList(articleids));
    }

}
