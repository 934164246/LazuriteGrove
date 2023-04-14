package com.rurigokou.back.game.service.impl;

import com.rurigokou.back.game.service.TagGameRelationService;
import com.rurigokou.common.dto.RuriPage;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.back.game.dao.TagGameRelationDao;
import com.rurigokou.back.game.entity.TagGameRelationEntity;

/**
* @author gokoururi
*/
@Service("tagGameRelationService")
public class TagGameRelationServiceImpl extends ServiceImpl<TagGameRelationDao, TagGameRelationEntity> implements TagGameRelationService {

    @Override
    public RuriPage queryPage(Map<String, Object> params) {
        return new RuriPage();
    }

}