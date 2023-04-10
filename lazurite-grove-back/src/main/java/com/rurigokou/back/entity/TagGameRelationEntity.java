package com.rurigokou.back.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 游戏标签联系表
 * 
 * @author gokoururi
 * @email rurigokou934164246@gmail.com
 * @date 2023-03-31 22:59:26
 */
@Data
@TableName("tag_game_relation")
public class TagGameRelationEntity implements Serializable {

	private static final long serialVersionUID = 1L;


	/**
	 * 游戏id
	 */
	private Integer gameId;

	/**
	 * 标签id
	 */
	private Integer tagId;

	/**
	 * 逻辑删除字段
	 */
	@TableLogic(value = "1", delval = "0")
	private Integer del;

}
