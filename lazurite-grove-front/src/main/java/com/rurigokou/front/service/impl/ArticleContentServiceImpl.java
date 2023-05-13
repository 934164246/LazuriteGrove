package com.rurigokou.front.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rurigokou.common.dto.RuriPage;
import com.rurigokou.front.entity.ArticleEntity;
import com.rurigokou.front.service.ArticleService;
import com.rurigokou.front.service.UserCommentService;
import com.rurigokou.front.service.UserFollowService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.front.dao.ArticleContentDao;
import com.rurigokou.front.entity.ArticleContentEntity;
import com.rurigokou.front.service.ArticleContentService;

import javax.annotation.Resource;

/**
* @author gokoururi
*/
@Service("articleContentService")
public class ArticleContentServiceImpl extends ServiceImpl<ArticleContentDao, ArticleContentEntity> implements ArticleContentService {

    @Resource(name = "userCommentService")
    private UserCommentService userCommentService;

    @Resource(name = "userFollowService")
    private UserFollowService userFollowService;

    @Resource(name = "articleService")
    @Lazy
    private ArticleService articleService;

    @Override
    public RuriPage queryPage(Map<String, Object> params) {
        return new RuriPage();
    }

    public boolean checkUserHasQualification(String articleId, Integer userId) {
        QueryWrapper<ArticleContentEntity> wrapper=new QueryWrapper<>();
        wrapper.eq("article_id", articleId);

        ArticleContentEntity entity = this.getOne(wrapper);

        switch (entity.getAccessMethod()) {
            case 0 : {
                return true;
            }
            case 1 : {
                ArticleEntity articleEntity = articleService.getById(articleId);
                if (articleEntity == null) {
                    return false;
                }

                return userFollowService.checkUserFollow(articleEntity.getUserId(), userId);
            }
            case 2: {
                return userCommentService.checkUserComment(articleId, userId);
            }
            default: {
                return false;
            }
        }
    }

    @Override
    public String getSourceLink(String articleId, Integer userId) {
        if (!checkUserHasQualification(articleId, userId)) {
            return null;
        }

        QueryWrapper<ArticleContentEntity> wrapper=new QueryWrapper<>();
        wrapper.eq("article_id", articleId);

        List<ArticleContentEntity> list = this.list(wrapper);

        if (list.size() == 1) {
            return list.get(0).getSourceLink();
        }

        return null;

    }

}