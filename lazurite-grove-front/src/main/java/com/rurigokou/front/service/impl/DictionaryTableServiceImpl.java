package com.rurigokou.front.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rurigokou.common.dto.RuriPage;
import com.rurigokou.common.exception.RuriErrorCodeEnum;
import com.rurigokou.common.exception.RuriException;
import com.rurigokou.front.dto.KeyValueDto;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.front.dao.DictionaryTableDao;
import com.rurigokou.front.entity.DictionaryTableEntity;
import com.rurigokou.front.service.DictionaryTableService;

/**
* @author gokoururi
*/
@Service("dictionaryTableService")
public class DictionaryTableServiceImpl extends ServiceImpl<DictionaryTableDao, DictionaryTableEntity> implements DictionaryTableService {

    @Override
    public List<KeyValueDto> info(String keyword) {
        QueryWrapper<DictionaryTableEntity> wrapper=new QueryWrapper<>();
        wrapper.likeRight("keyword", keyword)
                .ne("keyword", keyword);

        List<DictionaryTableEntity> list = this.list(wrapper);

        return list.stream()
                .sorted(Comparator.comparingInt(DictionaryTableEntity::getSort))
                .map(KeyValueDto::toDto)
                .collect(Collectors.toList());
    }

}