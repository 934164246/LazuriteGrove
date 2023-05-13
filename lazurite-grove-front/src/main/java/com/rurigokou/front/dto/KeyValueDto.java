package com.rurigokou.front.dto;

import com.rurigokou.front.entity.DictionaryTableEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gokoururi
 */
@Data
@EqualsAndHashCode
public class KeyValueDto {

    private String key;

    private String value;

    public static KeyValueDto toDto(DictionaryTableEntity entity) {
        KeyValueDto dto=new KeyValueDto();

        dto.setKey(entity.getName());
        dto.setValue(entity.getValue());

        return dto;
    }
}
