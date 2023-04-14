package com.rurigokou.back.game.service;

import com.rurigokou.common.dto.RuriPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.back.game.entity.TypeGameRelationEntity;

import java.util.Map;

/**
 * 游戏类型联系表
 *
 * @author gokoururi
 */
public interface TypeGameRelationService extends IService<TypeGameRelationEntity> {

    RuriPage queryPage(Map<String, Object> params);
}

