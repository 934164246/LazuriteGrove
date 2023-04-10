package com.rurigokou.back.controller;

import java.util.Arrays;
import java.util.Map;

import com.rurigokou.back.pagination.GameTagPage;
import org.springframework.web.bind.annotation.*;

import com.rurigokou.back.entity.GameTagEntity;
import com.rurigokou.back.service.GameTagService;
import com.rurigokou.common.dto.RuriPage;

import javax.annotation.Resource;


/**
 * 游戏标签表
 *
 * @author gokoururi
 */
@RestController
@RequestMapping("back/gametag")
public class GameTagController {

    @Resource(name = "gameTagService")
    private GameTagService gameTagService;

    @PostMapping("/page")
    public RuriPage list(@RequestBody GameTagPage page){
        return gameTagService.queryPage(page);
    }

    @GetMapping("/info/{id}")
    public GameTagEntity info(@PathVariable("id") Integer id){
		return gameTagService.getById(id);
    }

    @PostMapping("/saveOrUpdate")
    public Boolean save(@RequestBody GameTagEntity gameTag){
		return gameTagService.saveOrUpdate(gameTag);
    }

    @PostMapping("/delete")
    public Boolean delete(@RequestBody Integer[] ids){
		return gameTagService.removeByIds(Arrays.asList(ids));
    }

}
