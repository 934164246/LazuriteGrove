package com.rurigokou.back.service;

import com.rurigokou.common.dto.RuriPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.back.entity.GameEntity;

import java.util.Map;

/**
 * 游戏表
 *
 * @author gokoururi
 */
public interface GameService extends IService<GameEntity> {

    RuriPage queryPage(Map<String, Object> params);
}

