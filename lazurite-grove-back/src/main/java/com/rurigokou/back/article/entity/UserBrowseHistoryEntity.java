package com.rurigokou.back.article.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户浏览历史表
 * 
 * @author gokoururi
 * @email rurigokou934164246@gmail.com
 * @date 2023-04-14 15:29:34
 */
@Data
@TableName("user_browse_history")
public class UserBrowseHistoryEntity implements Serializable {
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
	 * 文章id
	 */
	private Integer articleid;

	/**
	 * 浏览时间
	 */
	private Date browsetime;

	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 逻辑删除字段
	 */
	private Integer del;

}
