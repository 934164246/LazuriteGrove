package com.rurigokou.front.dto;

import com.rurigokou.front.entity.UserEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author gokoururi
 */
@Data
@EqualsAndHashCode
public class UserInfoDto {

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
     * 头像
     */
    private String headImg;

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
     * 关注数
     */
    private Integer followNum;

    /**
     * 粉丝数量
     */
    private Integer fanNum;

    /**
     * entity -> userInfoDto
     *
     * @param entity entity
     * @return userInfoDto
     */
    public static UserInfoDto toDto(UserEntity entity) {
        UserInfoDto dto=new UserInfoDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setNickname(entity.getNickname());
        dto.setHeadImg(entity.getHeadImg());
        dto.setGender(entity.getGender());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setFollowNum(entity.getFollowNum());
        dto.setFanNum(entity.getFanNum());

        return dto;
    }
}
