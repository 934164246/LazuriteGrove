package com.rurigokou.back.service.impl;

import com.rurigokou.common.dto.RuriPage;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.back.dao.GameDao;
import com.rurigokou.back.entity.GameEntity;
import com.rurigokou.back.service.GameService;

/**
* @author gokoururi
*/
@Service("gameService")
public class GameServiceImpl extends ServiceImpl<GameDao, GameEntity> implements GameService {

    @Override
    public RuriPage queryPage(Map<String, Object> params) {
        return new RuriPage();
    }

}