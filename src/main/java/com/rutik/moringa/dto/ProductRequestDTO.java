package com.rutik.moringa.dto;

public class ProductRequestDTO {
    private String name;
    private double price;

    public ProductRequestDTO(){};

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }
}
