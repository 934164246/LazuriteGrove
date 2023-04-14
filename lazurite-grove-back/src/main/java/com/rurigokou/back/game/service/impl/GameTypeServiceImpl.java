package com.rurigokou.back.game.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rurigokou.back.game.pagination.GameTypePage;
import com.rurigokou.common.dto.RuriPage;
import com.rurigokou.common.pagination.RuriQuery;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.back.game.dao.GameTypeDao;
import com.rurigokou.back.game.entity.GameTypeEntity;
import com.rurigokou.back.game.service.GameTypeService;
import org.springframework.util.StringUtils;

/**
* @author gokoururi
*/
@Service("gameTypeService")
public class GameTypeServiceImpl extends ServiceImpl<GameTypeDao, GameTypeEntity> implements GameTypeService {

    @Override
    public RuriPage queryPage(GameTypePage page) {
        QueryWrapper<GameTypeEntity> wrapper=new QueryWrapper<>();
        wrapper.eq(StringUtils.hasText(page.getId()),"id", page.getId())
                .like(StringUtils.hasText(page.getName()), "name", page.getName());



        return RuriPage.tranToPageVo(this.page(RuriQuery.getPage(page), wrapper));
    }

}