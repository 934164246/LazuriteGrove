package com.rurigokou.front.service;

import com.rurigokou.common.dto.RuriPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.front.entity.ArticleEntity;

import java.util.Map;

/**
 * 文章
 *
 * @author gokoururi
 */
public interface ArticleService extends IService<ArticleEntity> {

    RuriPage queryPage(Map<String, Object> params);
}

