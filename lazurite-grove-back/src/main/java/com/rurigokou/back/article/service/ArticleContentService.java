package com.rurigokou.back.article.service;

import com.rurigokou.common.dto.RuriPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.back.article.entity.ArticleContentEntity;

import java.util.Map;

/**
 * 文章内容表
 *
 * @author gokoururi
 */
public interface ArticleContentService extends IService<ArticleContentEntity> {

    RuriPage queryPage(Map<String, Object> params);
}

