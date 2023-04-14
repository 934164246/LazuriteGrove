package com.rurigokou.back.article.service.impl;

import com.rurigokou.common.dto.RuriPage;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.back.article.dao.UserCommentDao;
import com.rurigokou.back.article.entity.UserCommentEntity;
import com.rurigokou.back.article.service.UserCommentService;

/**
* @author gokoururi
*/
@Service("userCommentService")
public class UserCommentServiceImpl extends ServiceImpl<UserCommentDao, UserCommentEntity> implements UserCommentService {

    @Override
    public RuriPage queryPage(Map<String, Object> params) {
        return new RuriPage();
    }

}