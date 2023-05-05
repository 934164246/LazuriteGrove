package com.rurigokou.front.service;

import com.rurigokou.common.dto.RuriPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rurigokou.front.dto.KeyValueDto;
import com.rurigokou.front.entity.DictionaryTableEntity;

import java.util.List;
import java.util.Map;

/**
 * 字典表
 *
 * @author gokoururi
 */
public interface DictionaryTableService extends IService<DictionaryTableEntity> {

    List<KeyValueDto> info(String keyword);
}

