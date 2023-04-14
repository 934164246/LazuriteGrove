package com.rurigokou.back.game.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * 系统角色表
 * 
 * @author gokoururi
 * @email rurigokou934164246@gmail.com
 * @date 2023-03-31 22:59:26
 */
@Data
@TableName("sys_role")
public class SysRoleEntity implements Serializable {

	private static final long serialVersionUID = 1L;


	/**
	 * id
	 */
	@TableId
	private Integer id;

	/**
	 * 角色名称
	 */
	private String name;

	/**
	 * 关键字
	 */
	private String keyword;

	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 逻辑删除字段
	 */
	@JsonIgnore
	@TableLogic(value = "1", delval = "0")
	private Integer del;

}
