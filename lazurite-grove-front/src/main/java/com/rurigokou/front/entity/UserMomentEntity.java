package com.rurigokou.front.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户动态表
 * 
 * @author gokoururi
 * @email rurigokou934164246@gmail.com
 */
@Data
@TableName("user_moment")
public class UserMomentEntity implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * id
	 */
	@TableId
	private String uid;

	/**
	 * 用户id
	 */
	private Integer userId;

	/**
	 * 内容
	 */
	private String content;

	/**
	 * 图片
	 */
	private String img;

	/**
	 * 发布时间
	 */
	private Date releaseTime;

	/**
	 * 点赞数
	 */
	private Integer likeNum;

	/**
	 * 评论数
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
