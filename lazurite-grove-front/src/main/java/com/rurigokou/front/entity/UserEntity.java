package com.rurigokou.front.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户表
 * 
 * @author gokoururi
 * @email rurigokou934164246@gmail.com
 */
@Data
@TableName("user")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;


	/**
	 * id
	 */
	@TableId
	private Integer id;

	/**
	 * 用户名
	 */
	private String name;

	/**
	 * 昵称
	 */
	private String nickname;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 头像
	 */
	public String headImg;

	/**
	 * 性别
	 */
	private Integer gender;

	/**
	 * 电子邮箱
	 */
	private String email;

	/**
	 * 电话号码
	 */
	private String phone;

	/**
	 * 身份证号码
	 */
	private String idNo;

	/**
	 * 关注数
	 */
	private Integer followNum;

	/**
	 * 粉丝数量
	 */
	private Integer fanNum;

	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 逻辑删除字段
	 */
	private Integer del;

}
