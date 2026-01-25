package com.rutik.moringa.service;

import com.rutik.moringa.dto.UserLoginDTO;
import com.rutik.moringa.dto.UserRegisterDTO;
import com.rutik.moringa.entity.UserEntity;
import com.rutik.moringa.repository.UserRepository;
import com.rutik.moringa.util.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthService {

    private final UserRepository userRepo;
    private final BCryptPasswordEncoder encoder;
    private final JwtUtil jwtUtil;


    public AuthService(UserRepository userRepo,
                       BCryptPasswordEncoder encoder,
                       JwtUtil jwtUtil) {
        this.userRepo = userRepo;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;

    }

    public void register(UserRegisterDTO dto){

        userRepo.findByEmail(dto.getEmail())
                .ifPresent(u ->{
                    throw new RuntimeException("Email already registerd");
                });

        String hashed = encoder.encode(dto.getPassword());

        UserEntity user = new UserEntity(dto.getEmail(), hashed);
        userRepo.save(user);
    }

    public String login(UserLoginDTO dto){

        UserEntity user = userRepo.findByEmail(dto.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Invalid Email or password"));

        boolean matches = encoder.matches(
                dto.getPassword() , user.getPassword()
        );

        if(!matches){
            throw new RuntimeException("Invalid Email or Password");
        }
        return jwtUtil.generateToken(user.getEmail());

    }
}
