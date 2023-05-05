package com.rurigokou.front.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rurigokou.common.dto.RuriPage;
import com.rurigokou.common.pagination.RuriQuery;
import com.rurigokou.front.dto.GameDto;
import com.rurigokou.front.entity.GameTypeEntity;
import com.rurigokou.front.pagination.GamePage;
import com.rurigokou.front.service.GameTypeService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.front.dao.GameDao;
import com.rurigokou.front.entity.GameEntity;
import com.rurigokou.front.service.GameService;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
* @author gokoururi
*/
@Service("gameService")
public class GameServiceImpl extends ServiceImpl<GameDao, GameEntity> implements GameService {

    @Resource(name = "gameTypeService")
    private GameTypeService typeService;


    @Override
    public RuriPage page(GamePage gamePage) {
        String typeName = null;

        //检测 typeKeyword是否为空，并设置typeName
        if (StringUtils.hasText(gamePage.getTypeKeyword()) && !"All".equals(gamePage.getTypeKeyword())) {
            GameTypeEntity gameTypeEntity = typeService.getOneByKeyword(gamePage.getTypeKeyword());

            if (gameTypeEntity != null) {
                typeName = gameTypeEntity.getName();
            }
        }

        QueryWrapper<GameEntity> wrapper = new QueryWrapper<>();
        wrapper.eq(StringUtils.hasText(typeName), "type", typeName)
                .like(StringUtils.hasText(gamePage.getGameName()), "game", gamePage.getGameName());

        //检查排序字段
        switch (gamePage.getSortParam()) {
            case "date": {
                wrapper.orderByDesc("create_time");
                break;
            }
            case "heat": {
                wrapper.orderByDesc("name");
                break;
            }
            default: {
                wrapper.orderByDesc("create_time");
            }
        }

        IPage<GameEntity> page = this.page(RuriQuery.getPage(gamePage), wrapper);

        // entity -> dto
        List<Object> gameDtoList = page.getRecords().stream()
                .map(GameDto::toDto)
                .peek(item -> item.setDescription(null))
                .collect(Collectors.toList());


        RuriPage ruriPage = RuriPage.tranToPageVo(page);
        ruriPage.setList(gameDtoList);


        return ruriPage;
    }

    @Override
    public GameDto info(Integer id) {
        GameEntity entity = this.getById(id);

        return GameDto.toDto(entity);
    }
}