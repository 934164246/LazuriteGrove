package com.rurigokou.front.service;

import com.rurigokou.common.dto.RuriPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.front.entity.ArticleContentEntity;

import java.util.Map;

/**
 * 文章内容表
 *
 * @author gokoururi
 */
public interface ArticleContentService extends IService<ArticleContentEntity> {

    RuriPage queryPage(Map<String, Object> params);
}

