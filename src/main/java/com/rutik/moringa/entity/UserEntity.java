package com.rutik.moringa.entity;

import jakarta.persistence.*;

import java.security.PrivateKey;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role; //USER or ADMIN

    public UserEntity() {}

    public UserEntity(String email,String password,String role){
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getId() { return id; }
    public String getEmail(){ return email; }
    public String getPassword(){ return password;}
    public String getRole(){ return role; }
}
