package com.rurigokou.back.game.dto;

import com.rurigokou.back.game.entity.DictionaryTableEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gokoururi
 */
@Data
@EqualsAndHashCode
public class DictionaryKeyDto {

    private String id;

    private String keyword;

    private String name;

    private String value;

    public static DictionaryKeyDto toDto(DictionaryTableEntity entity) {
        DictionaryKeyDto dto=new DictionaryKeyDto();
        dto.setId(entity.getUid());
        dto.setName(entity.getName());
        dto.setValue(entity.getValue());
        dto.setKeyword(entity.getKeyword());

        return dto;
    }
}
