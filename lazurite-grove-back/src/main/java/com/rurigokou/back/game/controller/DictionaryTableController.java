package com.rurigokou.back.game.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.rurigokou.back.game.dto.DictionaryKeyValueDto;
import com.rurigokou.back.game.dto.DictionaryModelDto;
import com.rurigokou.back.game.entity.DictionaryTableEntity;
import com.rurigokou.back.game.pagination.DictionaryTablePage;
import com.rurigokou.common.dto.RuriPage;
import com.rurigokou.common.exception.RuriErrorCodeEnum;
import com.rurigokou.common.exception.RuriException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.rurigokou.back.game.service.DictionaryTableService;

import javax.annotation.Resource;


/**
 * 字典表
 *
 * @author gokoururi
 */
@RestController
@RequestMapping("back/dict")
public class DictionaryTableController {

    @Resource(name = "dictionaryTableService")
    private DictionaryTableService dictionaryTableService;

    @PostMapping("modelList")
    public List<DictionaryModelDto> modelList(@RequestBody DictionaryTablePage dictionaryTablePage) {
        return dictionaryTableService.modelList(dictionaryTablePage);
    }

    @PostMapping("keyPage")
    public RuriPage keyPage(@RequestBody DictionaryTablePage dictionaryTablePage) {
        if (Objects.isNull(dictionaryTablePage) || !StringUtils.hasText(dictionaryTablePage.getParentId())) {
            throw new RuriException(RuriErrorCodeEnum.VALID_EXCEPTION);
        }

        return dictionaryTableService.queryPage(dictionaryTablePage);
    }

    @GetMapping("/keyInfo/{keyword}")
    public List<DictionaryKeyValueDto> info(@PathVariable("keyword") String keyword) {
        return dictionaryTableService.getByKeyword(keyword);
    }

    @PostMapping("/saveOrUpdate")
    public boolean saveOrUpdate(@RequestBody DictionaryTableEntity entity) {
        return dictionaryTableService.saveOrUpdate(entity);
    }

    @PostMapping("/delete")
    public boolean delete(@RequestBody String[] uids) {
        return dictionaryTableService.removeByIds(Arrays.asList(uids));
    }
}
