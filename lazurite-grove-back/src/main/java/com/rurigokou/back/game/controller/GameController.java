package com.rurigokou.back.game.controller;

import java.util.Arrays;

import com.rurigokou.back.game.entity.GameEntity;
import com.rurigokou.back.game.pagination.GamePage;
import org.springframework.web.bind.annotation.*;

import com.rurigokou.back.game.service.GameService;
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
    public RuriPage list(@RequestBody GamePage page) {
        return gameService.queryPage(page);
    }

    @GetMapping("/info/{id}")
    public GameEntity info(@PathVariable("id") Integer id) {
        return gameService.getById(id);
    }

    @PostMapping("/saveOrUpdate")
    public Object save(@RequestBody GameEntity game) {
        return gameService.saveOrUpdateById(game);
    }

    @PostMapping("/delete")
    public Boolean delete(@RequestBody Integer[] ids) {
        return gameService.removeByIds(Arrays.asList(ids));
    }

}
