package com.rurigokou.front.service.impl;

import com.rurigokou.common.dto.RuriPage;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.front.dao.GameTagDao;
import com.rurigokou.front.entity.GameTagEntity;
import com.rurigokou.front.service.GameTagService;

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