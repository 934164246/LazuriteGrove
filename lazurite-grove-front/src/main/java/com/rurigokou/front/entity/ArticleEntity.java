package com.rurigokou.front.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 文章
 * 
 * @author gokoururi
 * @email rurigokou934164246@gmail.com
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
	 * 创造者id
	 */
	private Integer userId;

	/**
	 * 标题
	 */
	private String title;

	/**
	 * 创造时间
	 */
	private Date createTime;

	/**
	 * 发布时间
	 */
	private Date releaseTime;

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
	@TableLogic(value = "1", delval = "0")
	private Integer del;

}
