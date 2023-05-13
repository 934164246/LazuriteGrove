package com.rurigokou.front.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.common.dto.RuriPage;
import com.rurigokou.front.dto.ArticleDetailDto;
import com.rurigokou.front.dto.ArticleDto;
import com.rurigokou.front.dto.ArticleRankDto;
import com.rurigokou.front.entity.ArticleEntity;
import com.rurigokou.front.pagination.ArticlePage;

import java.util.List;

/**
 * 文章
 *
 * @author gokoururi
 */
public interface ArticleService extends IService<ArticleEntity> {

    List<ArticleRankDto> getTop();

    List<ArticleRankDto> getRecent();

    Boolean save(ArticleDto dto);

    List<ArticleDto> getDrafts(Integer userId);

    ArticleDto getDraft(String uid);

    Boolean deleteArticle(String uid);

    Long getNowCount();

    RuriPage getList(ArticlePage page);

    ArticleDetailDto getDetail(String id, Integer userId);

    /**
     *
     * @param id id
     * @return sadf
     */
    Boolean articleCommentIncrease(String id);
}

