package com.rurigokou.front.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

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
	@TableId
	private String articleId;

	/**
	 * 文章内容
	 */
	private String content;

	/**
	 * 资源链接
	 */
	private String sourceLink;

	/**
	 * 获取方式
	 */
	private Integer accessMethod;

	/**
	 * 逻辑删除字段
	 */
	@TableLogic(value = "1", delval = "0")
	private Integer del;

}
