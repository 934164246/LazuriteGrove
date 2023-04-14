package com.rurigokou.back.game.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户角色表
 * 
 * @author gokoururi
 * @email rurigokou934164246@gmail.com
 * @date 2023-03-31 22:59:26
 */
@Data
@TableName("sys_user_role")
public class SysUserRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * 用户id
	 */
	@TableId
	private Integer userid;

	/**
	 * 角色id
	 */
	private Integer roleid;

}
