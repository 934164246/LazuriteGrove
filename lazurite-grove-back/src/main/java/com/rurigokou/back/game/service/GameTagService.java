package com.rurigokou.back.game.service;

import com.rurigokou.back.game.pagination.GameTagPage;
import com.rurigokou.common.dto.RuriPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.back.game.entity.GameTagEntity;

import java.util.Map;

/**
 * 游戏标签表
 *
 * @author gokoururi
 */
public interface GameTagService extends IService<GameTagEntity> {

    RuriPage queryPage(GameTagPage page);

    Map<String, String> getAllTag();
}

