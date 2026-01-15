package com.rutik.moringa.service;

import com.rutik.moringa.dto.ProductRequestDTO;
import com.rutik.moringa.dto.ProductResponseDTO;
import com.rutik.moringa.entity.ProductEntity;
import com.rutik.moringa.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public ProductEntity addProduct(ProductRequestDTO dto){
        ProductEntity product = new ProductEntity(dto.getName(), dto.getPrice());
        return repo.save(product);
    }

    public List<ProductResponseDTO> getAllProducts(){

        List<ProductEntity> products = repo.findAll();

        return products.stream()
                .map(p -> new ProductResponseDTO(
                        p.getId(),
                        p.getName(),
                        p.getPrice()
                ))
                .toList();
    }
}
