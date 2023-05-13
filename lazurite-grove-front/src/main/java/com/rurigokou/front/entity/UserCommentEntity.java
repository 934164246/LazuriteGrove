package com.rurigokou.front.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户评论表
 * 
 * @author gokoururi
 * @email rurigokou934164246@gmail.com
 * @date 2023-04-24 14:52:57
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
	private Integer userId;

	/**
	 * 文章类型
	 */
	private String commentType;

	/**
	 * 文章id
	 */
	private String objectId;

	/**
	 * 评论时间
	 */
	private Date commentTime;

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
	@TableLogic(value = "1", delval = "0")
	private Integer del;

}
