package com.rurigokou.back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.back.dto.DictionaryKeyValueDto;
import com.rurigokou.back.dto.DictionaryModelDto;
import com.rurigokou.back.entity.UserEntity;
import com.rurigokou.back.pagination.DictionaryTablePage;
import com.rurigokou.common.dto.RuriPage;
import com.rurigokou.back.entity.DictionaryTableEntity;

import java.util.List;
import java.util.Map;

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

