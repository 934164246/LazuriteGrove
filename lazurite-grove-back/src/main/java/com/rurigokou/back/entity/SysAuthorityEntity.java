package com.rurigokou.back.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 权限表
 * 
 * @author gokoururi
 * @email rurigokou934164246@gmail.com
 * @date 2023-03-31 22:59:26
 */
@Data
@TableName("sys_authority")
public class SysAuthorityEntity implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * id
	 */
	@TableId
	private Integer id;

	/**
	 * 父菜单id，一级菜单为0
	 */
	private Integer parentId;

	/**
	 * 菜单名
	 */
	private String name;

	/**
	 * 类型
	 */
	private Integer type;

	/**
	 * 路径地址
	 */
	private String path;

	/**
	 * 组件路径
	 */
	private String url;

	/**
	 * 图标
	 */
	private String icon;

	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 排序
	 */
	private Integer sort;

	/**
	 * 逻辑删除字段
	 */

	@TableLogic(value = "1", delval = "0")
	private Integer del;

}
