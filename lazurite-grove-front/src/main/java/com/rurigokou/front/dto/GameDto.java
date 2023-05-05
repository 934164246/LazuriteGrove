package com.rurigokou.front.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.rurigokou.front.entity.GameEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author gokoururi
 */
@Data
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameDto {

    private Integer id;

    private String name;

    private String img;

    private String type;

    private List<String> tags;

    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public static GameDto toDto(GameEntity game) {
        GameDto dto = new GameDto();

        dto.setId(game.getId());
        dto.setName(game.getName());
        dto.setImg(game.getImg());
        dto.setType(game.getType());
        dto.setTags(StringUtils.hasText(game.getTag()) ? Arrays.asList(game.getTag().split(";")) : new ArrayList<>());
        dto.setDescription(game.getDescription());
        dto.setDate(game.getCreateTime());

        return dto;
    }
}
