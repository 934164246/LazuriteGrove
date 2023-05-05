package com.rurigokou.front.controller;

import java.util.List;

import com.rurigokou.common.dto.RuriPage;
import com.rurigokou.front.dto.GameDto;
import com.rurigokou.front.pagination.GamePage;
import org.springframework.web.bind.annotation.*;

import com.rurigokou.front.service.GameService;

import javax.annotation.Resource;



/**
 * 游戏表
 *
 * @author gokoururi
 */
@RestController
@RequestMapping("front/game")
public class GameController {

    @Resource(name = "gameService")
    private GameService gameService;

    @GetMapping("page")
    public RuriPage page(@ModelAttribute GamePage pagination) {

        return gameService.page(pagination);
    }

    @GetMapping("info/{id}")
    public GameDto info(@PathVariable("id") Integer id) {
        return gameService.info(id);
    }
}
