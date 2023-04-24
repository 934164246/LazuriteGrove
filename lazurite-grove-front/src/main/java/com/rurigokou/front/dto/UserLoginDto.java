package com.rurigokou.front.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @author gokoururi
 */
@Data
@EqualsAndHashCode
public class UserLoginDto {

    @NotNull
    private String username;

    @NotNull
    private String password;
}
