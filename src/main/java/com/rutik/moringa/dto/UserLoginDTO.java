package com.rutik.moringa.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.jspecify.annotations.Nullable;

public class UserLoginDTO {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    public String getEmail(){ return email; }

    public String getPassword() { return password; }

}
