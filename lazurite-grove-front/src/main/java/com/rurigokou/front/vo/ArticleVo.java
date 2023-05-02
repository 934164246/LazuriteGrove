package com.rurigokou.front.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rurigokou.front.dto.UserInfoDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author gokoururi
 */
@Data
@EqualsAndHashCode
public class ArticleVo {

    private String uid;

    private UserInfoDto userInfo;

    private String title;

    private String context;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date releaseTime;

    private String coverImg;

    private String sourceLink;
}
