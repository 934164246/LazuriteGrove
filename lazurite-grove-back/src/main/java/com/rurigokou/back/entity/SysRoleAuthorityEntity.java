package com.rurigokou.back.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * 角色权限表
 * 
 * @author gokoururi
 * @email rurigokou934164246@gmail.com
 * @date 2023-03-31 22:59:26
 */
@Data
@TableName("sys_role_authority")
public class SysRoleAuthorityEntity implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * 角色id
	 */
	@TableId
	private Integer roleId;

	/**
	 * 权限id
	 */
	private Integer authorityId;

	/**
	 * 逻辑删除字段
	 */
	@JsonIgnore
	@TableLogic(value = "1", delval = "0")
	private Integer del;

}
