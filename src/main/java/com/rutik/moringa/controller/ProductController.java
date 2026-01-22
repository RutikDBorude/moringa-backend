package com.rutik.moringa.controller;

import com.rutik.moringa.dto.ProductRequestDTO;
import com.rutik.moringa.dto.ProductResponseDTO;
import com.rutik.moringa.entity.ProductEntity;
import com.rutik.moringa.service.ProductService;
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

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ProductEntity createProduct(
            @Valid @RequestBody ProductRequestDTO dto){
        return service.addProduct(dto);
    }

    @GetMapping
    public Page<ProductResponseDTO> getProducts(Pageable pageable){
        return service.getProducts(pageable);
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
    @GetMapping("/search")
    public List<ProductResponseDTO> searchByName(
            @RequestParam String name){
        return service.searchByName(name);
    }

    @GetMapping("/filter")
    public List<ProductResponseDTO> filterByPrice(
            @RequestParam double minPrice,
            @RequestParam double maxPrice){

        return service.filterByPrice(minPrice,maxPrice);
    }





}
