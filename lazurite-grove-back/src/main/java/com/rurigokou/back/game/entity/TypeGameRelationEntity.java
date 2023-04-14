package com.rurigokou.back.game.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 游戏类型联系表
 * 
 * @author gokoururi
 * @email rurigokou934164246@gmail.com
 */
@Data
@TableName("type_game_relation")
public class TypeGameRelationEntity implements Serializable {

	private static final long serialVersionUID = 1L;


	/**
	 * 游戏id
	 */
	private Integer gameId;

	/**
	 * 标签id
	 */
	private Integer typeId;

	/**
	 * 逻辑删除字段
	 */
	@TableLogic(value = "1", delval = "0")
	private Integer del;

}
