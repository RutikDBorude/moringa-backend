package com.rutik.moringa.service;

import com.rutik.moringa.dto.ProductRequestDTO;
import com.rutik.moringa.dto.ProductResponseDTO;
import com.rutik.moringa.entity.ProductEntity;
import com.rutik.moringa.exception.ProductNotFoundException;
import com.rutik.moringa.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<ProductResponseDTO> getProducts(Pageable pageable) {
        return repo.findAll(pageable)
                .map(p -> new ProductResponseDTO(
                        p.getId(),
                        p.getName(),
                        p.getPrice()
                ));
    }

    public ProductResponseDTO getProductById(Long id) {
        ProductEntity product = repo.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException(
                                "Product not found with id"+id));
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }

    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO dto) {

        ProductEntity product = repo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: "+ id));

        product.setName(dto.getName());
        product.setPrice(dto.getPrice());

        ProductEntity updated = repo.save(product);

        return new ProductResponseDTO(
                updated.getId(),
                updated.getName(),
                updated.getPrice()
        );

    }

    public void deleteProduct(Long id) {

        ProductEntity product = repo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(
                        "product not found with id: " +id));


        repo.delete(product);
    }


}
