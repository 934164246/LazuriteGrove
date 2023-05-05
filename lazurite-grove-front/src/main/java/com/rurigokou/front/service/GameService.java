package com.rurigokou.front.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.common.dto.RuriPage;
import com.rurigokou.front.dto.GameDto;
import com.rurigokou.front.entity.GameEntity;
import com.rurigokou.front.pagination.GamePage;

import java.util.List;

/**
 * 游戏表
 *
 * @author gokoururi
 */
public interface GameService extends IService<GameEntity> {

    RuriPage page(GamePage page);

    GameDto info(Integer id);
}

