package com.rurigokou.back.service;

import com.rurigokou.common.dto.RuriPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.back.entity.GameTypeEntity;

import java.util.Map;

/**
 * 游戏类型表
 *
 * @author gokoururi
 */
public interface GameTypeService extends IService<GameTypeEntity> {

    RuriPage queryPage(Map<String, Object> params);
}

