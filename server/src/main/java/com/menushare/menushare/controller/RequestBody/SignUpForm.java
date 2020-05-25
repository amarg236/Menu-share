package com.menushare.menushare.controller.RequestBody;

import com.menushare.menushare.model.RoleName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class SignUpForm {
    @NotBlank
    @NotEmpty(message= "First Name must not be empty!")
    private String firstname;

    @NotBlank
    @NotEmpty(message= "Last Name must not be empty!")
    private String lastname;

    @NotBlank
    @NotEmpty(message= "UserName must not be empty!")
    private String username;


    @NotBlank
    @NotEmpty(message= "Password must not be empty!")
    @Size(min= 6, max = 30)
    private String password;

    private Set<String> role;

//    private boolean verified = false;
}
