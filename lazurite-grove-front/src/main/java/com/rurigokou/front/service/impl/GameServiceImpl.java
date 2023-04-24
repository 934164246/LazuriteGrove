package com.rurigokou.front.service.impl;

import com.rurigokou.common.dto.RuriPage;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.front.dao.GameDao;
import com.rurigokou.front.entity.GameEntity;
import com.rurigokou.front.service.GameService;

/**
* @author gokoururi
*/
@Service("gameService")
public class GameServiceImpl extends ServiceImpl<GameDao, GameEntity> implements GameService {


}