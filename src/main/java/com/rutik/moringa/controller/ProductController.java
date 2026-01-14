package com.rutik.moringa.controller;

import com.rutik.moringa.entity.ProductEntity;
import com.rutik.moringa.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ProductEntity createProduct(){
        return service.addProduct();
    }
}
