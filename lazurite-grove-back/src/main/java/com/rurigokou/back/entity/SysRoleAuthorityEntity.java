package com.rurigokou.back.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
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
	private Integer roleid;

	/**
	 * 权限id
	 */
	private Integer authorityid;

	/**
	 * 逻辑删除字段
	 */
	private Integer del;

}
