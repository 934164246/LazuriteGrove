package com.rurigokou.back.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.rurigokou.back.entity.GameEntity;
import com.rurigokou.back.service.GameService;
import com.rurigokou.common.dto.RuriPage;

import javax.annotation.Resource;



/**
 * 游戏表
 *
 * @author gokoururi
 */
@RestController
@RequestMapping("back/game")
public class GameController {

    @Resource(name = "gameService")
    private GameService gameService;

    @PostMapping("/page")
    public RuriPage list(@RequestBody Map<String, Object> params){
        return gameService.queryPage(params);
    }

    @GetMapping("/info/{id}")
    public GameEntity info(@PathVariable("id") Integer id){
		return gameService.getById(id);
    }

    @PostMapping("/saveOrUpdate")
    public Boolean save(@RequestBody GameEntity game){
		return gameService.saveOrUpdate(game);
    }

    @PostMapping("/delete")
    public Boolean delete(@RequestBody Integer[] ids){
		return gameService.removeByIds(Arrays.asList(ids));
    }

}
