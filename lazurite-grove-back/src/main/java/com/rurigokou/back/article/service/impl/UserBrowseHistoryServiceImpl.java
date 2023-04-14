package com.rurigokou.back.article.service.impl;

import com.rurigokou.common.dto.RuriPage;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.back.article.dao.UserBrowseHistoryDao;
import com.rurigokou.back.article.entity.UserBrowseHistoryEntity;
import com.rurigokou.back.article.service.UserBrowseHistoryService;

/**
* @author gokoururi
*/
@Service("userBrowseHistoryService")
public class UserBrowseHistoryServiceImpl extends ServiceImpl<UserBrowseHistoryDao, UserBrowseHistoryEntity> implements UserBrowseHistoryService {

    @Override
    public RuriPage queryPage(Map<String, Object> params) {
        return new RuriPage();
    }

}