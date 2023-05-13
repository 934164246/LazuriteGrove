package com.rurigokou.front.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author gokoururi
 */
@Data
@EqualsAndHashCode
public class UserMomentDto {

    private Integer type;

    private String id;

    private Integer userId;

    private String headImg;

    private String nickname;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date date;

    private String content;

    private String img;
}
