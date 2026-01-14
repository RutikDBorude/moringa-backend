package com.rutik.moringa.service;

import com.rutik.moringa.entity.ProductEntity;
import com.rutik.moringa.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public ProductEntity addProduct(){
        ProductEntity product = new ProductEntity("moringa powder",299D);
        return repo.save(product);
    }
}
