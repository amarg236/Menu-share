package com.menushare.menushare.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {
    @NotBlank(message= "username cannot be blank")
    private String Username;

    @NotBlank(message = "Password can not be blank")
    private String password;

}
