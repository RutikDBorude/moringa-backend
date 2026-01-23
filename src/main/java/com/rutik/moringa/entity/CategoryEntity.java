package com.rutik.moringa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categories")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public CategoryEntity(){

    }

    public CategoryEntity(String name){
        this.name = name;
    }

    public Long getId(){ return id; };

    public String getName(){ return name; }

    @OneToMany(mappedBy = "category")
    private List<ProductEntity> products;



}
