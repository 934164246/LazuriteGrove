package com.rurigokou.back.game.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rurigokou.back.game.entity.GameEntity;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author gokoururi
 */
@Data
public class GameDto {

    private Integer id;

    private String name;

    private String img;

    private String type;

    private List<String> tag;

    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    private Integer status;

    private String statusName;

    public static GameDto toDto(GameEntity entity) {
        GameDto dto=new GameDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setImg(entity.getImg());
        dto.setType(entity.getType());
        dto.setDescription(entity.getDescription());
        dto.setCreateTime(entity.getCreateTime());
        dto.setStatus(entity.getStatus());

        return dto;
    }
}
