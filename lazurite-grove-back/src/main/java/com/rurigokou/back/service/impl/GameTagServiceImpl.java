package com.rurigokou.back.service.impl;

import com.rurigokou.common.dto.RuriPage;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.back.dao.GameTagDao;
import com.rurigokou.back.entity.GameTagEntity;
import com.rurigokou.back.service.GameTagService;

/**
* @author gokoururi
*/
@Service("gameTagService")
public class GameTagServiceImpl extends ServiceImpl<GameTagDao, GameTagEntity> implements GameTagService {

    @Override
    public RuriPage queryPage(Map<String, Object> params) {
        return new RuriPage();
    }

}