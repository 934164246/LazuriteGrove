package com.rurigokou.front.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rurigokou.common.dto.RuriPage;
import com.rurigokou.common.exception.RuriErrorCodeEnum;
import com.rurigokou.common.exception.RuriException;
import com.rurigokou.common.pagination.RuriQuery;
import com.rurigokou.front.dto.UserCommentDto;
import com.rurigokou.front.entity.ArticleEntity;
import com.rurigokou.front.entity.UserEntity;
import com.rurigokou.front.entity.UserMomentEntity;
import com.rurigokou.front.pagination.UserCommentPage;
import com.rurigokou.front.service.ArticleService;
import com.rurigokou.front.service.UserMomentService;
import com.rurigokou.front.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.front.dao.UserCommentDao;
import com.rurigokou.front.entity.UserCommentEntity;
import com.rurigokou.front.service.UserCommentService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @author gokoururi
*/
@Slf4j
@Service("userCommentService")
public class UserCommentServiceImpl extends ServiceImpl<UserCommentDao, UserCommentEntity> implements UserCommentService {

    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "articleService")
    private ArticleService articleService;

    @Resource(name = "userMomentService")
    private UserMomentService userMomentService;

    @Override
    public Boolean checkUserComment(String articleId, Integer userId) {
        QueryWrapper<UserCommentEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId)
                .eq("comment_type", "1")
                .eq("object_id", articleId)
                .eq("status", 1);

        List<UserCommentEntity> list = this.list(wrapper);

        return list.size() > 0;
    }

    @Override
    public RuriPage page(UserCommentPage page, String type) {
        QueryWrapper<UserCommentEntity> wrapper=new QueryWrapper<>();
        wrapper.eq("comment_type", type)
                .eq("object_id", page.getId());

        IPage<UserCommentEntity> ipage = this.page(RuriQuery.getPage(page), wrapper);

        List<Object> collect = ipage.getRecords().stream()
                .sorted(Comparator.comparing(UserCommentEntity::getCommentTime).reversed())
                .map(item -> {
                    UserCommentDto dto = new UserCommentDto();
                    UserEntity user = userService.getById(item.getUserId());


                    dto.setUid(item.getUid());
                    dto.setContent(item.getContent());
                    dto.setDate(item.getCommentTime());
                    dto.setUserId(item.getUserId());
                    dto.setHeadImg(user.getHeadImg());
                    dto.setNickname(user.getNickname());
                    return dto;
                })
                .collect(Collectors.toList());

        RuriPage ruriPage = RuriPage.tranToPageVo(ipage);
        ruriPage.setList(collect);

        return ruriPage;
    }

    @Override
    @Transactional
    public Boolean saveAsArticle(UserCommentDto dto) {
        ArticleEntity article = articleService.getById(dto.getObjectId());

        if (article == null) {
            log.error("用户文章不存在");
            throw new RuriException(RuriErrorCodeEnum.UNKNOWN_EXCEPTION);
        }

        UserCommentEntity entity=new UserCommentEntity();

        entity.setUserId(dto.getUserId());
        entity.setCommentType("1");
        entity.setCommentTime(dto.getDate());
        entity.setContent(dto.getContent());
        entity.setObjectId(dto.getObjectId());

        if (!this.save(entity)) {
            return false;
        }

        articleService.articleCommentIncrease(article.getUid());
        return true;
    }

    @Override
    public Boolean saveAsMoment(UserCommentDto dto) {
        UserMomentEntity moment = userMomentService.getById(dto.getObjectId());

        if (moment == null) {
            log.error("用户不存在");
            throw new RuriException(RuriErrorCodeEnum.UNKNOWN_EXCEPTION);
        }

        UserCommentEntity entity=new UserCommentEntity();

        entity.setUserId(dto.getUserId());
        entity.setCommentType("2");
        entity.setCommentTime(dto.getDate());
        entity.setContent(dto.getContent());
        entity.setObjectId(dto.getObjectId());

        if (!this.save(entity)) {
            return false;
        }

        System.out.println("123");
        //todo 新增评论
        return true;
    }
}