package com.rurigokou.back.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.rurigokou.back.entity.TagGameRelationEntity;
import com.rurigokou.back.service.TagGameRelationService;
import com.rurigokou.common.dto.RuriPage;

import javax.annotation.Resource;



/**
 * 游戏标签联系表
 *
 * @author gokoururi
 */
@RestController
@RequestMapping("back/taggamerelation")
public class TagGameRelationController {

    @Resource(name = "tagGameRelationService")
    private TagGameRelationService tagGameRelationService;

    @PostMapping("/page")
    public RuriPage list(@RequestBody Map<String, Object> params) {
        return tagGameRelationService.queryPage(params);
    }

    @GetMapping("/info/{gameId}")
    public TagGameRelationEntity info(@PathVariable("gameId") Integer gameid) {
        return tagGameRelationService.getById(gameid);
    }

    @PostMapping("/saveOrUpdate")
    public Boolean save(@RequestBody TagGameRelationEntity tagGameRelation) {
        return tagGameRelationService.saveOrUpdate(tagGameRelation);
    }

    @PostMapping("/delete")
    public Boolean delete(@RequestBody Integer[] gameids) {
        return tagGameRelationService.removeByIds(Arrays.asList(gameids));
    }

}
