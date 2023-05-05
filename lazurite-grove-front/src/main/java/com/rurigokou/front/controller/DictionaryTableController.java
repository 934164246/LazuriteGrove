package com.rurigokou.front.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.rurigokou.front.dto.KeyValueDto;
import org.springframework.web.bind.annotation.*;

import com.rurigokou.front.entity.DictionaryTableEntity;
import com.rurigokou.front.service.DictionaryTableService;
import com.rurigokou.common.dto.RuriPage;

import javax.annotation.Resource;



/**
 * 字典表
 *
 * @author gokoururi
 */
@RestController
@RequestMapping("front/dictionary")
public class DictionaryTableController {

    @Resource(name = "dictionaryTableService")
    private DictionaryTableService dictionaryTableService;

    @GetMapping("info/{keyword}")
    public List<KeyValueDto> getByKeyword(@PathVariable("keyword") String keyword) {

        return null;
    }
}
