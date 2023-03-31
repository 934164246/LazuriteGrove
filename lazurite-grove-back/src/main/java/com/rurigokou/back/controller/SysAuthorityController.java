package com.rurigokou.back.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.rurigokou.back.entity.SysAuthorityEntity;
import com.rurigokou.back.service.SysAuthorityService;
import com.rurigokou.common.dto.RuriPage;

import javax.annotation.Resource;



/**
 * 权限表
 *
 * @author gokoururi
 */
@RestController
@RequestMapping("back/sysauthority")
public class SysAuthorityController {

    @Resource(name = "sysAuthorityService")
    private SysAuthorityService sysAuthorityService;

    @PostMapping("/page")
    public RuriPage list(@RequestBody Map<String, Object> params){
        return sysAuthorityService.queryPage(params);
    }

    @GetMapping("/info/{id}")
    public SysAuthorityEntity info(@PathVariable("id") Integer id){
		return sysAuthorityService.getById(id);
    }

    @PostMapping("/saveOrUpdate")
    public Boolean save(@RequestBody SysAuthorityEntity sysAuthority){
		return sysAuthorityService.saveOrUpdate(sysAuthority);
    }

    @PostMapping("/delete")
    public Boolean delete(@RequestBody Integer[] ids){
		return sysAuthorityService.removeByIds(Arrays.asList(ids));
    }

}
