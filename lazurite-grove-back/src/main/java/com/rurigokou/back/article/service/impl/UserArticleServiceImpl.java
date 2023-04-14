package com.rurigokou.back.article.service.impl;

import com.rurigokou.common.dto.RuriPage;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.back.article.dao.UserArticleDao;
import com.rurigokou.back.article.entity.UserArticleEntity;
import com.rurigokou.back.article.service.UserArticleService;

/**
* @author gokoururi
*/
@Service("userArticleService")
public class UserArticleServiceImpl extends ServiceImpl<UserArticleDao, UserArticleEntity> implements UserArticleService {

    @Override
    public RuriPage queryPage(Map<String, Object> params) {
        return new RuriPage();
    }

}