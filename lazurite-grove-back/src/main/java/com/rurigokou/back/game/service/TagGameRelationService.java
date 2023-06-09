package com.rurigokou.back.game.service;

import com.rurigokou.common.dto.RuriPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.back.game.entity.TagGameRelationEntity;

import java.util.Map;

/**
 * 游戏标签联系表
 *
 * @author gokoururi
 */
public interface TagGameRelationService extends IService<TagGameRelationEntity> {

    RuriPage queryPage(Map<String, Object> params);
}

