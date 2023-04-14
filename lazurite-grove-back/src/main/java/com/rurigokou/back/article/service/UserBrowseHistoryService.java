package com.rurigokou.back.article.service;

import com.rurigokou.common.dto.RuriPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.back.article.entity.UserBrowseHistoryEntity;

import java.util.Map;

/**
 * 用户浏览历史表
 *
 * @author gokoururi
 */
public interface UserBrowseHistoryService extends IService<UserBrowseHistoryEntity> {

    RuriPage queryPage(Map<String, Object> params);
}

