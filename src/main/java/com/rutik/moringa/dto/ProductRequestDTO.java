package com.rutik.moringa.dto;
import jakarta.validation.constraints.*;

public class ProductRequestDTO {

    @NotBlank(message = "Product name is required")
    private String name;

    @Positive(message = "Price must be greater than 0")
    private double price;

    public ProductRequestDTO(){};

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }
}
