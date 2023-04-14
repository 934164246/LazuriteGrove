package com.rurigokou.back.game.controller;

import java.util.Arrays;
import java.util.Map;

import com.rurigokou.back.game.entity.TypeGameRelationEntity;
import org.springframework.web.bind.annotation.*;

import com.rurigokou.back.game.service.TypeGameRelationService;
import com.rurigokou.common.dto.RuriPage;

import javax.annotation.Resource;



/**
 * 游戏类型联系表
 *
 * @author gokoururi
 */
@RestController
@RequestMapping("back/typegamerelation")
public class TypeGameRelationController {

    @Resource(name = "typeGameRelationService")
    private TypeGameRelationService typeGameRelationService;

    @PostMapping("/page")
    public RuriPage list(@RequestBody Map<String, Object> params){
        return typeGameRelationService.queryPage(params);
    }

    @GetMapping("/info/{gameId}")
    public TypeGameRelationEntity info(@PathVariable("gameId") Integer gameId){
		return typeGameRelationService.getById(gameId);
    }

    @PostMapping("/saveOrUpdate")
    public Boolean save(@RequestBody TypeGameRelationEntity typeGameRelation){
		return typeGameRelationService.saveOrUpdate(typeGameRelation);
    }

    @PostMapping("/delete")
    public Boolean delete(@RequestBody Integer[] gameids){
		return typeGameRelationService.removeByIds(Arrays.asList(gameids));
    }

}
