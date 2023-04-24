package com.rurigokou.front.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.rurigokou.front.entity.GameEntity;
import com.rurigokou.front.service.GameService;
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


}
