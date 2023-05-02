package com.rurigokou.front.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rurigokou.common.dto.RuriPage;
import com.rurigokou.common.exception.RuriException;
import com.rurigokou.front.dto.ArticleDto;
import com.rurigokou.front.dto.ArticleRankDto;
import com.rurigokou.front.entity.ArticleContentEntity;
import com.rurigokou.front.service.ArticleContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.front.dao.ArticleDao;
import com.rurigokou.front.entity.ArticleEntity;
import com.rurigokou.front.service.ArticleService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
* @author gokoururi
*/
@Service("articleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, ArticleEntity> implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Resource(name = "articleContentService")
    private ArticleContentService articleContentService;

    @Override
    public List<ArticleRankDto> getTop() {
        List<ArticleRankDto> article = articleDao.getArticle();

        // 按照readNum*0.6 + likeNum*0.2 + commentNum*0.2来排序
        return article.stream()
                .sorted((t1, t2) -> (int) ((t2.getReadNum() * 0.6 + t2.getLikeNum() * 0.2 + t2.getCommentNum() * 0.2)-(t1.getReadNum() * 0.6 + t1.getLikeNum() * 0.2 + t1.getCommentNum() * 0.2)))
                .limit(30)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleRankDto> getRecent() {
        List<ArticleRankDto> article = articleDao.getArticle();

        //按照时间排序
        return article.stream()
                .sorted((t1, t2) -> t2.getDate().compareTo(t1.getDate()))
                .limit(30)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Boolean save(ArticleDto dto) {
        boolean isSave=true;

        //判断uid是否在数据库里面存在
        if (StringUtils.hasText(dto.getUid())) {
            ArticleEntity entity = this.getById(dto.getUid());

            if(entity != null) {
                isSave=false;
            }
        }

        //是否为新增
        if (isSave) {
            ArticleEntity entity=ArticleDto.toEntity(dto);
            entity.setCreateTime(dto.getReleaseTime());

            if (this.save(entity)) {
                ArticleContentEntity contentEntity = ArticleDto.toContentEntity(dto);
                contentEntity.setArticleId(entity.getUid());

                articleContentService.save(contentEntity);
            } else {
                return false;
            }
        } else {
            ArticleEntity entity=ArticleDto.toEntity(dto);

            if (this.updateById(entity)) {
                ArticleContentEntity contentEntity = ArticleDto.toContentEntity(dto);

                QueryWrapper<ArticleContentEntity> wrapper=new QueryWrapper<>();
                wrapper.eq("article_id", dto.getUid());

                articleContentService.update(contentEntity, wrapper);
            } else {
                return false;
            }
        }

        return true;
    }

    @Override
    public List<ArticleDto> getDrafts(Integer userId) {
        QueryWrapper<ArticleEntity> wrapper=new QueryWrapper<>();
        wrapper.eq("user_id", userId)
                .eq("status", 2);

        List<ArticleEntity> list = this.list(wrapper);

        List<ArticleDto> result=new ArrayList<>(list.size());

        // entity -> dto
        for (ArticleEntity entity : list) {
            ArticleDto dto=new ArticleDto();

            dto.setUid(entity.getUid());
            dto.setCoverImg(entity.getCoverImg());
            dto.setReleaseTime(entity.getReleaseTime());
            dto.setTitle(entity.getTitle());

            result.add(dto);
        }

        result.sort(Comparator.comparing(ArticleDto::getReleaseTime).reversed());

        return result;
    }

    @Override
    public ArticleDto getDraft(String uid) {
        QueryWrapper<ArticleEntity> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("status", 2)
                .eq("uid", uid);

        ArticleEntity entity = this.getOne(queryWrapper);


        ArticleDto dto =new ArticleDto();
        if (entity != null) {
            QueryWrapper<ArticleContentEntity> wrapper=new QueryWrapper<>();
            wrapper.eq("article_id", uid);

            ArticleContentEntity articleContentEntity = articleContentService.getOne(wrapper);

            dto.setUid(entity.getUid());
            dto.setTitle(entity.getTitle());
            dto.setUserId(entity.getUserId());
            dto.setContent(articleContentEntity.getContent());
            dto.setReleaseTime(entity.getReleaseTime());
            dto.setCoverImg(entity.getCoverImg());
            dto.setSourceLink(articleContentEntity.getSourceLink());
        }

        return dto;
    }

    @Override
    @Transactional(rollbackFor = {RuriException.class})
    public Boolean deleteArticle(String uid) {
        return this.removeById(uid);
    }

    @Override
    public Long getNowCount() {
        QueryWrapper<ArticleEntity> wrapper=new QueryWrapper<>();
        wrapper.eq("status", 1);

        return this.count(wrapper);
    }
}