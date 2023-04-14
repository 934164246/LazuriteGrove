package com.rurigokou.back.game.dto;

import com.rurigokou.back.game.entity.DictionaryTableEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gokoururi
 */
@Data
@EqualsAndHashCode
public class DictionaryKeyValueDto {

    private String name;

    private String value;

    public static DictionaryKeyValueDto toDto(DictionaryTableEntity entity) {
        DictionaryKeyValueDto dto=new DictionaryKeyValueDto();
        dto.setName(entity.getName());
        dto.setValue(entity.getValue());

        return dto;
    }
}
