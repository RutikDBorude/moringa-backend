package com.rutik.moringa.controller;

import com.rutik.moringa.dto.UserLoginDTO;
import com.rutik.moringa.dto.UserRegisterDTO;
import com.rutik.moringa.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@Valid @RequestBody UserRegisterDTO dto){
        authService.register(dto);
        return "User registered Successfully";
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody UserLoginDTO dto){
        return authService.login(dto);

    }
}
