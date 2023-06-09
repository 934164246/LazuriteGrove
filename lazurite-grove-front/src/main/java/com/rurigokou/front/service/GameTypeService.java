package com.rurigokou.front.service;

import com.rurigokou.common.dto.RuriPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.front.dto.KeyValueDto;
import com.rurigokou.front.entity.GameTypeEntity;

import java.util.List;
import java.util.Map;

/**
 * 游戏类型表
 *
 * @author gokoururi
 */
public interface GameTypeService extends IService<GameTypeEntity> {

    List<KeyValueDto> getAll();

    GameTypeEntity getOneByKeyword(String keyword);
}

