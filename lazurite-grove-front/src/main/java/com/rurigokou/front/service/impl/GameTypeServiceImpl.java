package com.rurigokou.front.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rurigokou.common.dto.RuriPage;
import com.rurigokou.front.dto.KeyValueDto;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public List<KeyValueDto> getAll() {
        List<GameTypeEntity> list = this.list();

        return list.stream()
                .sorted(Comparator.comparingInt(GameTypeEntity::getSort))
                .map(item -> {
                    KeyValueDto dto = new KeyValueDto();
                    dto.setKey(item.getKeyword());
                    dto.setValue(item.getName());

                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public GameTypeEntity getOneByKeyword(String keyword) {
        QueryWrapper<GameTypeEntity> wrapper=new QueryWrapper<>();
        wrapper.eq("keyword", keyword);

        return this.getOne(wrapper);
    }
}