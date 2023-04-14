package com.rurigokou.back.article.service.impl;

import com.rurigokou.common.dto.RuriPage;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.back.article.dao.ArticleUserHistoryDao;
import com.rurigokou.back.article.entity.ArticleUserHistoryEntity;
import com.rurigokou.back.article.service.ArticleUserHistoryService;

/**
* @author gokoururi
*/
@Service("articleUserHistoryService")
public class ArticleUserHistoryServiceImpl extends ServiceImpl<ArticleUserHistoryDao, ArticleUserHistoryEntity> implements ArticleUserHistoryService {

    @Override
    public RuriPage queryPage(Map<String, Object> params) {
        return new RuriPage();
    }

}