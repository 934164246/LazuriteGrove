package com.rurigokou.back.article.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.rurigokou.back.article.entity.UserBrowseHistoryEntity;
import com.rurigokou.back.article.service.UserBrowseHistoryService;
import com.rurigokou.common.dto.RuriPage;

import javax.annotation.Resource;



/**
 * 用户浏览历史表
 *
 * @author gokoururi
 */
@RestController
@RequestMapping("back/userbrowsehistory")
public class UserBrowseHistoryController {

    @Resource(name = "userBrowseHistoryService")
    private UserBrowseHistoryService userBrowseHistoryService;

    @PostMapping("/page")
    public RuriPage list(@RequestBody Map<String, Object> params){
        return userBrowseHistoryService.queryPage(params);
    }

    @GetMapping("/info/{id}")
    public UserBrowseHistoryEntity info(@PathVariable("id") Integer id){
		return userBrowseHistoryService.getById(id);
    }

    @PostMapping("/saveOrUpdate")
    public Boolean save(@RequestBody UserBrowseHistoryEntity userBrowseHistory){
		return userBrowseHistoryService.saveOrUpdate(userBrowseHistory);
    }

    @PostMapping("/delete")
    public Boolean delete(@RequestBody Integer[] ids){
		return userBrowseHistoryService.removeByIds(Arrays.asList(ids));
    }

}
