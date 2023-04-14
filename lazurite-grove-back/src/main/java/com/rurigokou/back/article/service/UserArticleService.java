package com.rurigokou.back.article.service;

import com.rurigokou.common.dto.RuriPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.back.article.entity.UserArticleEntity;

import java.util.Map;

/**
 * 用户文章表
 *
 * @author gokoururi
 */
public interface UserArticleService extends IService<UserArticleEntity> {

    RuriPage queryPage(Map<String, Object> params);
}

