package com.rutik.moringa.controller;

import com.rutik.moringa.dto.ProductRequestDTO;
import com.rutik.moringa.dto.ProductResponseDTO;
import com.rutik.moringa.entity.ProductEntity;
import com.rutik.moringa.service.ProductService;
import com.rutik.moringa.util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.SimpleTimeZone;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;
    private final JwtUtil jwtUtil;

    public ProductController(ProductService service, JwtUtil jwtUtil) {
        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public ProductEntity createProduct(
            @Valid @RequestBody ProductRequestDTO dto){
        return service.addProduct(dto);
    }

    @GetMapping
    public Page<ProductResponseDTO> getProducts(
            @RequestParam(required = false) String name,Pageable pageable)
    {
        return service.getProducts(name,pageable);
    }

    @GetMapping("/{id}")
    public ProductResponseDTO getProductById(@PathVariable Long id){
        return service.getProductById(id);
    }

    @PutMapping("/{id}")
    public ProductResponseDTO updateProduct(
            @PathVariable Long id,
            @RequestBody ProductRequestDTO dto){
        return service.updateProduct(id,dto);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        service.deleteProduct(id);
        return "Product deleted successfully";
    }

    @GetMapping("/secure-test")
    public String secureTest(
            @RequestHeader("Authorization") String authHeader){

        String token = authHeader.replace("Bearer","");
        String email = jwtUtil.extractEmail(token);

        return "Access granted for user: " + email;
    }







}
