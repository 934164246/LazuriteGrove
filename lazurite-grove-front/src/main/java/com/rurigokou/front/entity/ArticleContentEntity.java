package com.rurigokou.front.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 文章内容表
 *
 * @author gokoururi
 * @email rurigokou934164246@gmail.com
 */
@Data
@TableName("article_content")
public class ArticleContentEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 文章id
     */
    @TableId(value = "article_id",type = IdType.AUTO)
    private String articleId;

    /**
     * 文章内容
     */
    @TableField("content")
    private String content;

    /**
     * 资源链接
     */
    @TableField("source_link")
    private String sourceLink;

    /**
     * 获取方式
     */
    @TableField("access_method")
    private Integer accessMethod;

    /**
     * 逻辑删除字段
     */
    @TableLogic(value = "1", delval = "0")
    private Integer del;

}
