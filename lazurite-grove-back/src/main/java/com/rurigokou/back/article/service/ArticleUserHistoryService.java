package com.rurigokou.back.article.service;

import com.rurigokou.common.dto.RuriPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.back.article.entity.ArticleUserHistoryEntity;

import java.util.Map;

/**
 * 文章资源用户获取表
 *
 * @author gokoururi
 */
public interface ArticleUserHistoryService extends IService<ArticleUserHistoryEntity> {

    RuriPage queryPage(Map<String, Object> params);
}

