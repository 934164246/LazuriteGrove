package com.rurigokou.front.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.rurigokou.front.entity.GameTypeEntity;
import com.rurigokou.front.service.GameTypeService;
import com.rurigokou.common.dto.RuriPage;

import javax.annotation.Resource;



/**
 * 游戏类型表
 *
 * @author gokoururi
 */
@RestController
@RequestMapping("front/gametype")
public class GameTypeController {

    @Resource(name = "gameTypeService")
    private GameTypeService gameTypeService;

    @PostMapping("/page")
    public RuriPage list(@RequestBody Map<String, Object> params){
        return gameTypeService.queryPage(params);
    }

    @GetMapping("/info/{id}")
    public GameTypeEntity info(@PathVariable("id") Integer id){
		return gameTypeService.getById(id);
    }

    @PostMapping("/saveOrUpdate")
    public Boolean save(@RequestBody GameTypeEntity gameType){
		return gameTypeService.saveOrUpdate(gameType);
    }

    @PostMapping("/delete")
    public Boolean delete(@RequestBody Integer[] ids){
		return gameTypeService.removeByIds(Arrays.asList(ids));
    }

}
