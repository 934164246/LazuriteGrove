package com.rurigokou.back.game.service;

import com.rurigokou.common.dto.RuriPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.back.game.entity.SysUserRoleEntity;

import java.util.Map;

/**
 * 用户角色表
 *
 * @author gokoururi
 */
public interface SysUserRoleService extends IService<SysUserRoleEntity> {

    RuriPage queryPage(Map<String, Object> params);
}

