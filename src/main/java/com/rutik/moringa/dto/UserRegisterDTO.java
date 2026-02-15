package com.rutik.moringa.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserRegisterDTO {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    public UserRegisterDTO(){

    }

    public UserRegisterDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public String getPassword(){
        return password;
    }

}
