package com.rurigokou.front.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

/**
 * @author gokoururi
 */
@Data
@EqualsAndHashCode
public class UserRegisterDto {

    @Email(message = "邮箱格式不正确")
    private String email;

    @Size(min = 6, max = 18)
    private String password;
}
