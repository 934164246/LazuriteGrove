package com.rurigokou.back.service;

import com.rurigokou.common.dto.RuriPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.back.entity.GameTagEntity;

import java.util.Map;

/**
 * 游戏标签表
 *
 * @author gokoururi
 */
public interface GameTagService extends IService<GameTagEntity> {

    RuriPage queryPage(Map<String, Object> params);
}

