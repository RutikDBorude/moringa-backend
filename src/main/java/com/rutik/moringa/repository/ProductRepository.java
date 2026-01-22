package com.rutik.moringa.repository;
import com.rutik.moringa.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {


    Page<ProductEntity> findByNameContainingIgnoreCase(String name,Pageable pageable);
}
