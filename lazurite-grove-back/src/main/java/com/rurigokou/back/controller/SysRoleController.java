package com.rurigokou.back.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.rurigokou.back.entity.SysRoleEntity;
import com.rurigokou.back.service.SysRoleService;
import com.rurigokou.common.dto.RuriPage;

import javax.annotation.Resource;



/**
 * 系统角色表
 *
 * @author gokoururi
 */
@RestController
@RequestMapping("back/sysrole")
public class SysRoleController {

    @Resource(name = "sysRoleService")
    private SysRoleService sysRoleService;

    @PostMapping("/page")
    public RuriPage list(@RequestBody Map<String, Object> params){
        return sysRoleService.queryPage(params);
    }

    @GetMapping("/info/{id}")
    public SysRoleEntity info(@PathVariable("id") Integer id){
		return sysRoleService.getById(id);
    }

    @PostMapping("/saveOrUpdate")
    public Boolean save(@RequestBody SysRoleEntity sysRole){
		return sysRoleService.saveOrUpdate(sysRole);
    }

    @PostMapping("/delete")
    public Boolean delete(@RequestBody Integer[] ids){
		return sysRoleService.removeByIds(Arrays.asList(ids));
    }

}
