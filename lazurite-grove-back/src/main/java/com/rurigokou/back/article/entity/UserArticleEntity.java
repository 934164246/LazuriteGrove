package com.rurigokou.back.article.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户文章表
 * 
 * @author gokoururi
 * @email rurigokou934164246@gmail.com
 * @date 2023-04-14 15:29:34
 */
@Data
@TableName("user_article")
public class UserArticleEntity implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * id
	 */
	@TableId
	private Integer id;

	/**
	 * 用户id
	 */
	private Integer userid;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 创造时间
	 */
	private Date createtime;

	/**
	 * 发布时间
	 */
	private Date releasetime;

	/**
	 * 封面图片
	 */
	private String coverimg;

	/**
	 * 阅读量
	 */
	private Integer readnum;

	/**
	 * 点赞量
	 */
	private Integer likenum;

	/**
	 * 评论量
	 */
	private Integer commentnum;

	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 逻辑删除字段
	 */
	private Integer del;

}
