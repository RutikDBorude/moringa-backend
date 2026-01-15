package com.rutik.moringa.controller;

import com.rutik.moringa.dto.ProductRequestDTO;
import com.rutik.moringa.dto.ProductResponseDTO;
import com.rutik.moringa.entity.ProductEntity;
import com.rutik.moringa.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ProductEntity createProduct(
            @RequestBody ProductRequestDTO dto){
        return service.addProduct(dto);
    }

    @GetMapping
    public List<ProductResponseDTO> getProducts(){
        return service.getAllProducts();
    }
}
