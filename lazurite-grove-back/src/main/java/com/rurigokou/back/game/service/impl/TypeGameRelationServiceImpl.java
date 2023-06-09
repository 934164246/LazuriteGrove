package com.rurigokou.back.game.service.impl;

import com.rurigokou.common.dto.RuriPage;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.back.game.dao.TypeGameRelationDao;
import com.rurigokou.back.game.entity.TypeGameRelationEntity;
import com.rurigokou.back.game.service.TypeGameRelationService;

/**
* @author gokoururi
*/
@Service("typeGameRelationService")
public class TypeGameRelationServiceImpl extends ServiceImpl<TypeGameRelationDao, TypeGameRelationEntity> implements TypeGameRelationService {

    @Override
    public RuriPage queryPage(Map<String, Object> params) {
        return new RuriPage();
    }

}