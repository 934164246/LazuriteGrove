package com.rurigokou.back.game.service;

import com.rurigokou.back.game.pagination.GameTypePage;
import com.rurigokou.common.dto.RuriPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.back.game.entity.GameTypeEntity;

/**
 * 游戏类型表
 *
 * @author gokoururi
 */
public interface GameTypeService extends IService<GameTypeEntity> {

    RuriPage queryPage(GameTypePage page);
}

