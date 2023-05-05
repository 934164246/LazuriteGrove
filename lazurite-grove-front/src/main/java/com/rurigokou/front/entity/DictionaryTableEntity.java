package com.rurigokou.front.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 字典表
 * 
 * @author gokoururi
 * @email rurigokou934164246@gmail.com
 * @date 2023-04-24 14:52:57
 */
@Data
@TableName("dictionary_table")
public class DictionaryTableEntity implements Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * uid
	 */
	@TableId
	private String uid;

	/**
	 * 父节点
	 */
	private String parentId;

	/**
	 * 关键字
	 */
	private String keyword;

	/**
	 * 层级
	 */
	private Integer level;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 值
	 */
	private String value;

	/**
	 * 排序字段
	 */
	private Integer sort;

	/**
	 * 逻辑删除字段
	 */
	private Integer del;

}
