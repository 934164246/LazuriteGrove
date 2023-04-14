package com.rurigokou.back.article.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户评论表
 * 
 * @author gokoururi
 * @email rurigokou934164246@gmail.com
 * @date 2023-04-14 15:29:34
 */
@Data
@TableName("user_comment")
public class UserCommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * uid
	 */
	@TableId
	private String uid;

	/**
	 * 用户id
	 */
	private Integer userid;

	/**
	 * 文章类型
	 */
	private String commenttype;

	/**
	 * 文章id
	 */
	private Integer articleid;

	/**
	 * 评论时间
	 */
	private Date commenttime;

	/**
	 * 评论内容
	 */
	private String content;

	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 逻辑删除字段
	 */
	private Integer del;

}
