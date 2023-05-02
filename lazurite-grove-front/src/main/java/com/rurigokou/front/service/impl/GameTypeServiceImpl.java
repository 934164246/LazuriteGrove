package com.rurigokou.front.service.impl;

import com.rurigokou.common.dto.RuriPage;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.front.dao.GameTypeDao;
import com.rurigokou.front.entity.GameTypeEntity;
import com.rurigokou.front.service.GameTypeService;

/**
* @author gokoururi
*/
@Service("gameTypeService")
public class GameTypeServiceImpl extends ServiceImpl<GameTypeDao, GameTypeEntity> implements GameTypeService {

    @Override
    public RuriPage queryPage(Map<String, Object> params) {
        return new RuriPage();
    }

}