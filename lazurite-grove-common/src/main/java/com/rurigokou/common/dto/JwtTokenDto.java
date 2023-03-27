package com.rurigokou.common.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * jwt认证类
 *
 * @author gokoururi
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class JwtTokenDto {

    private Integer id;

    private String name;

    /**
     * 过期时长，单位：min
     */
    private Long exp;

    /**
     * 签发时间
     */
    private Date iat;

    private String userAgent;
}
