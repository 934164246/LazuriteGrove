package com.rurigokou.back.article.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 文章
 * 
 * @author gokoururi
 * @email rurigokou934164246@gmail.com
 * @date 2023-04-14 15:29:33
 */
@Data
@TableName("article")
public class ArticleEntity implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * id
	 */
	@TableId
	private String uid;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 创造者id
	 */
	private Integer userId;

	/**
	 * 创造时间
	 */
	private Date createTime;

	/**
	 * 外部图片
	 */
	private String coverImg;

	/**
	 * 阅读量
	 */
	private Integer readNum;

	/**
	 * 喜欢数量
	 */
	private Integer likeNum;

	/**
	 * 评论数量
	 */
	private Integer commentNum;

	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 逻辑删除字段
	 */
	private Integer del;

}
