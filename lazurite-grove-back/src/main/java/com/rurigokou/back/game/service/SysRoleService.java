package com.rurigokou.back.game.service;

import com.rurigokou.common.dto.RuriPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.back.game.entity.SysRoleEntity;

import java.util.Map;

/**
 * 系统角色表
 *
 * @author gokoururi
 */
public interface SysRoleService extends IService<SysRoleEntity> {

    RuriPage queryPage(Map<String, Object> params);
}

