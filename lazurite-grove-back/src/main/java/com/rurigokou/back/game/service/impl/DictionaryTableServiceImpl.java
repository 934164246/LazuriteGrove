package com.rurigokou.back.game.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.rurigokou.back.game.dto.DictionaryKeyDto;
import com.rurigokou.back.game.dto.DictionaryKeyValueDto;
import com.rurigokou.back.game.dto.DictionaryModelDto;
import com.rurigokou.back.game.pagination.DictionaryTablePage;
import com.rurigokou.common.dto.RuriPage;
import com.rurigokou.common.pagination.RuriQuery;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rurigokou.back.game.dao.DictionaryTableDao;
import com.rurigokou.back.game.entity.DictionaryTableEntity;
import com.rurigokou.back.game.service.DictionaryTableService;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;


/**
 * @author gokoururi
 */
@Service("dictionaryTableService")
public class DictionaryTableServiceImpl extends ServiceImpl<DictionaryTableDao, DictionaryTableEntity> implements DictionaryTableService {

    @Override
    public List<DictionaryModelDto> modelList(DictionaryTablePage dictionaryTablePage) {
        QueryWrapper<DictionaryTableEntity> wrapper = new QueryWrapper<>();
        wrapper.in("level", 0, 1);
        wrapper.like(StringUtils.hasLength(dictionaryTablePage.getName()), "name", dictionaryTablePage.getName());

        List<DictionaryTableEntity> records = this.list(wrapper);

        Map<String, List<DictionaryTableEntity>> contentMap = records.stream()
                .filter(item -> item.getLevel().equals(1))
                .collect(Collectors.groupingBy(DictionaryTableEntity::getParentId));

        return records.stream()
                .filter(item -> item.getLevel().equals(0))
                .sorted(Comparator.comparingInt(DictionaryTableEntity::getSort))
                .map(DictionaryModelDto::toDto)
                .peek(item -> {
                    List<DictionaryTableEntity> dictionary = contentMap.getOrDefault(item.getId(), new ArrayList<>());
                    dictionary.sort(Comparator.comparingInt(DictionaryTableEntity::getSort));
                    item.setChildren(DictionaryModelDto.toDto(dictionary));
                })
                .collect(Collectors.toList());
    }

    @Override
    public RuriPage queryPage(DictionaryTablePage dictionaryTablePage) {
        QueryWrapper<DictionaryTableEntity> wrapper = new QueryWrapper<>();
        wrapper.like(StringUtils.hasText(dictionaryTablePage.getName()), "name", dictionaryTablePage.getName())
                .eq("parent_id", dictionaryTablePage.getParentId())
                .eq("level", 2);

        IPage<DictionaryTableEntity> page = this.page(RuriQuery.getPage(dictionaryTablePage), wrapper);

        List<DictionaryKeyDto> keyDtoList = page.getRecords().stream()
                .sorted(Comparator.comparingInt(DictionaryTableEntity::getSort))
                .map(DictionaryKeyDto::toDto)
                .collect(Collectors.toList());

        RuriPage pageVo = RuriPage.tranToPageVo(page);
        pageVo.setList(new ArrayList<>(keyDtoList));

        return pageVo;
    }

    @Override
    public List<DictionaryKeyValueDto> getByKeyword(String keyword) {
        QueryWrapper<DictionaryTableEntity> wrapper = new QueryWrapper<>();
        wrapper.likeRight("keyword", keyword);
        wrapper.ne("keyword", keyword);
        wrapper.eq("level", 2);

        List<DictionaryTableEntity> list = this.list(wrapper);

        return list.stream()
                .sorted(Comparator.comparingInt(DictionaryTableEntity::getSort))
                .map(DictionaryKeyValueDto::toDto)
                .collect(Collectors.toList());
    }
}