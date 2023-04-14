package com.rurigokou.back.article.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 文章资源用户获取表
 * 
 * @author gokoururi
 * @email rurigokou934164246@gmail.com
 * @date 2023-04-14 15:29:34
 */
@Data
@TableName("article_user_history")
public class ArticleUserHistoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * 文章id
	 */
	@TableId
	private Integer articleid;

	/**
	 * 用户id
	 */
	private Integer userid;

	/**
	 * 获取资源的时间
	 */
	private Date obtainedtime;

	/**
	 * 逻辑删除字段
	 */
	private Integer del;

}
