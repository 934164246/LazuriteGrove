package com.rurigokou.front.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 游戏表
 * 
 * @author gokoururi
 * @email rurigokou934164246@gmail.com
 * @date 2023-04-14 15:29:33
 */
@Data
@TableName("game")
public class GameEntity implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * id
	 */
	@TableId
	private Integer id;

	/**
	 * 游戏名称
	 */
	private String name;

	/**
	 * 游戏图片
	 */
	private String img;

	/**
	 * 游戏类型
	 */
	private String type;

	/**
	 * 游戏标签
	 */
	private String tag;

	/**
	 * 游戏描述
	 */
	private String description;

	/**
	 * 创造时间
	 */
	private Date createTime;

	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 逻辑删除字段
	 */
	private Integer del;

}
