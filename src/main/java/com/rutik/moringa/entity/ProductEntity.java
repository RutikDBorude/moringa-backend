package com.rutik.moringa.entity;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name="products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;

    //required by Jpa (no args constructor)
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
    public ProductEntity() {}

    public ProductEntity(String name,Double price){
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }



}
