package com.rurigokou.front.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.rurigokou.front.entity.ArticleEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author gokoururi
 */
@Data
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArticleDetailDto {

    public String id;

    private Integer userId;

    private String nickname;

    private Integer userFan;

    private Integer articleNum;

    private Boolean isFollow;

    private String headImg;

    private String coverImg;

    private String title;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date releaseTime;

    private Integer readNum;

    private Integer likeNum;

    private Integer commentNum;

    private Integer accessMethod;

    private String sourceLink;

    private String content;
}
