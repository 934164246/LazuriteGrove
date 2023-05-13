package com.rurigokou.front.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author gokoururi
 */
@Data
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserCommentDto {

    private String uid;

    private Integer userId;

    private String headImg;

    private String nickname;

    private String objectId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date date;

    private String content;
}
