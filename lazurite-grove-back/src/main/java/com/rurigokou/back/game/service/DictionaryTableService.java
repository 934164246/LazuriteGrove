package com.rurigokou.back.game.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.back.game.dto.DictionaryKeyValueDto;
import com.rurigokou.back.game.dto.DictionaryModelDto;
import com.rurigokou.back.game.pagination.DictionaryTablePage;
import com.rurigokou.common.dto.RuriPage;
import com.rurigokou.back.game.entity.DictionaryTableEntity;

import java.util.List;

/**
 * 字典表
 *
 * @author gokoururi
 */
public interface DictionaryTableService extends IService<DictionaryTableEntity> {

    List<DictionaryModelDto> modelList(DictionaryTablePage dictionaryTablePage);

    RuriPage queryPage(DictionaryTablePage dictionaryTablePage);

    List<DictionaryKeyValueDto> getByKeyword(String keyword);
}

