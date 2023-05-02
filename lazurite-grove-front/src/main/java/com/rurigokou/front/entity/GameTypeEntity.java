package com.rurigokou.front.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 游戏类型表
 * 
 * @author gokoururi
 * @email rurigokou934164246@gmail.com
 * @date 2023-04-24 14:52:57
 */
@Data
@TableName("game_type")
public class GameTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * id
	 */
	@TableId
	private Integer id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 关键字
	 */
	private String keyword;

	/**
	 * 排序字段
	 */
	private Integer sort;

	/**
	 * 逻辑删除字段
	 */
	private Integer del;

}
