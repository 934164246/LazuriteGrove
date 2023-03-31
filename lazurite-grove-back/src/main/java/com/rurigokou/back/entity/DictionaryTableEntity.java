package com.rurigokou.back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 字典表
 * 
 * @author gokoururi
 */
@Data
@TableName("dictionary_table")
public class DictionaryTableEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * uid
	 */
	@TableId(type = IdType.ASSIGN_UUID)
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
	@TableLogic(value = "1", delval = "0")
	private Integer del;
}
