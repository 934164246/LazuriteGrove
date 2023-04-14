package com.rurigokou.back.game.dto;

import com.rurigokou.back.game.entity.DictionaryTableEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gokoururi
 */
@Data
@EqualsAndHashCode
public class DictionaryModelDto {

    private String id;

    private String name;

    private String keyword;

    private List<DictionaryModelDto> children;

    public static DictionaryModelDto toDto(DictionaryTableEntity entity) {
        DictionaryModelDto dto=new DictionaryModelDto();
        dto.setId(entity.getUid());
        dto.setName(entity.getName());
        dto.setKeyword(entity.getKeyword());
        dto.setChildren(new ArrayList<>(10));

        return dto;
    }

    public static List<DictionaryModelDto> toDto(List<DictionaryTableEntity> entities) {
        if (CollectionUtils.isEmpty(entities)) {
            return new ArrayList<>();
        }

        return entities.stream()
                .map(DictionaryModelDto::toDto)
                .collect(Collectors.toList());
    }
}
