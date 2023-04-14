package com.rurigokou.back.game.service;

import com.rurigokou.back.game.pagination.GamePage;
import com.rurigokou.common.dto.RuriPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.back.game.entity.GameEntity;

/**
 * 游戏表
 *
 * @author gokoururi
 */
public interface GameService extends IService<GameEntity> {

    RuriPage queryPage(GamePage page);

    Object saveOrUpdateById(GameEntity entity);
}

