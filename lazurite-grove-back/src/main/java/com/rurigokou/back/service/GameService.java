package com.rurigokou.back.service;

import com.rurigokou.back.pagination.GamePage;
import com.rurigokou.common.dto.RuriPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.back.entity.GameEntity;

/**
 * 游戏表
 *
 * @author gokoururi
 */
public interface GameService extends IService<GameEntity> {

    RuriPage queryPage(GamePage page);

    Object saveOrUpdateById(GameEntity entity);
}

