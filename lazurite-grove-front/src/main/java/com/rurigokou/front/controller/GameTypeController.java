package com.rurigokou.front.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.rurigokou.front.dto.KeyValueDto;
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
@RequestMapping("front/gameType")
public class GameTypeController {

    @Resource(name = "gameTypeService")
    private GameTypeService gameTypeService;

    @GetMapping("/all")
    public List<KeyValueDto> getAll() {
        return gameTypeService.getAll();
    }

    @GetMapping("/getInfo/{keyword}")
    public KeyValueDto getByKeyword(@PathVariable("keyword") String keyword) {
        return null;
    }
}
