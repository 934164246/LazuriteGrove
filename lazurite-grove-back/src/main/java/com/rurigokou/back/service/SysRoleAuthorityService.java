package com.rurigokou.back.service;

import com.rurigokou.common.dto.RuriPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.back.entity.SysRoleAuthorityEntity;

import java.util.Map;

/**
 * 角色权限表
 *
 * @author gokoururi
 */
public interface SysRoleAuthorityService extends IService<SysRoleAuthorityEntity> {

    RuriPage queryPage(Map<String, Object> params);
}

