package com.rurigokou.front.service.impl;

import com.rurigokou.common.dto.RuriPage;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.front.dao.ArticleContentDao;
import com.rurigokou.front.entity.ArticleContentEntity;
import com.rurigokou.front.service.ArticleContentService;

/**
* @author gokoururi
*/
@Service("articleContentService")
public class ArticleContentServiceImpl extends ServiceImpl<ArticleContentDao, ArticleContentEntity> implements ArticleContentService {

    @Override
    public RuriPage queryPage(Map<String, Object> params) {
        return new RuriPage();
    }

}