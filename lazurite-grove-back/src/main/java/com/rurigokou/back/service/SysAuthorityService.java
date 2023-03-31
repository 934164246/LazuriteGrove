package com.rurigokou.back.service;

import com.rurigokou.common.dto.RuriPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.back.entity.SysAuthorityEntity;

import java.util.Map;

/**
 * 权限表
 *
 * @author gokoururi
 */
public interface SysAuthorityService extends IService<SysAuthorityEntity> {

    RuriPage queryPage(Map<String, Object> params);
}

