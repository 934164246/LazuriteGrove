package com.rurigokou.back.game.controller;

import java.util.Arrays;

import com.rurigokou.back.game.entity.GameTypeEntity;
import com.rurigokou.back.game.pagination.GameTypePage;
import org.springframework.web.bind.annotation.*;

import com.rurigokou.back.game.service.GameTypeService;
import com.rurigokou.common.dto.RuriPage;

import javax.annotation.Resource;



/**
 * 游戏类型表
 *
 * @author gokoururi
 */
@RestController
@RequestMapping("back/gametype")
public class GameTypeController {

    @Resource(name = "gameTypeService")
    private GameTypeService gameTypeService;

    @PostMapping("/page")
    public RuriPage list(@RequestBody GameTypePage page){
        return gameTypeService.queryPage(page);
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
