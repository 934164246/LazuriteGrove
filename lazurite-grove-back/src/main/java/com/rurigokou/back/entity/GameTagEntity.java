package com.rurigokou.back.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * 游戏标签表
 * 
 * @author gokoururi
 */
@Data
@TableName("game_tag")
public class GameTagEntity implements Serializable {

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
	@JsonIgnore
	@TableLogic(value = "1", delval = "0")
	private Integer del;

}
