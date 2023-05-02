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
public class ArticleRankDto {

    private String uid;

    private String userId;

    private String userName;

    private String userHeadImg;

    private String title;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date date;

    private String coverImg;

    private Integer readNum;

    private Integer likeNum;

    private Integer commentNum;
}
