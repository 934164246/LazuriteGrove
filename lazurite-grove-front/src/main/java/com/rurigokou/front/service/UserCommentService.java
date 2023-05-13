package com.rurigokou.front.service;

import com.rurigokou.common.dto.RuriPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.front.dto.UserCommentDto;
import com.rurigokou.front.entity.UserCommentEntity;
import com.rurigokou.front.pagination.UserCommentPage;

import java.util.Map;

/**
 * 用户评论表
 *
 * @author gokoururi
 */
public interface UserCommentService extends IService<UserCommentEntity> {

    Boolean checkUserComment(String articleId, Integer userId);

    RuriPage page(UserCommentPage page, String type);

    Boolean saveAsArticle(UserCommentDto dto);

    Boolean saveAsMoment(UserCommentDto dto);
}

