package com.rurigokou.back.service.impl;

import com.rurigokou.common.dto.RuriPage;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.back.dao.TagGameRelationDao;
import com.rurigokou.back.entity.TagGameRelationEntity;
import com.rurigokou.back.service.TagGameRelationService;

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