package com.rurigokou.back.article.service;

import com.rurigokou.common.dto.RuriPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.back.article.entity.UserCommentEntity;

import java.util.Map;

/**
 * 用户评论表
 *
 * @author gokoururi
 */
public interface UserCommentService extends IService<UserCommentEntity> {

    RuriPage queryPage(Map<String, Object> params);
}

