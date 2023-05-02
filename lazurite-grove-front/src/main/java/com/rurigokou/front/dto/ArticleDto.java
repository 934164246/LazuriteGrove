package com.rurigokou.front.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.rurigokou.front.entity.ArticleContentEntity;
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
public class ArticleDto {

    private String uid;

    private Integer userId;

    private String title;

    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date releaseTime;

    private String coverImg;

    private String sourceLink;

    private Integer status;

    /**
     * dto -> entity
     *
     * @param dto dto
     * @return ArticleEntity
     */
    public static ArticleEntity toEntity(ArticleDto dto) {
        ArticleEntity entity=new ArticleEntity();

        entity.setUid(dto.getUid());
        entity.setUserId(dto.getUserId());
        entity.setTitle(dto.getTitle());
        entity.setReleaseTime(dto.getReleaseTime());
        entity.setCoverImg(dto.getCoverImg());
        entity.setStatus(dto.getStatus());

        return entity;
    }

    /**
     * dto -> contentEntity
     *
     * @param dto dto
     * @return ArticleContentEntity
     */
    public static ArticleContentEntity toContentEntity(ArticleDto dto) {
        ArticleContentEntity entity=new ArticleContentEntity();

        entity.setArticleId(dto.getUid());
        entity.setContent(dto.getContent());
        entity.setSourceLink(dto.getSourceLink());

        return entity;
    }
}
