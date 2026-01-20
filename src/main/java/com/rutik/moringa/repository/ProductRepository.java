package com.rutik.moringa.repository;
import com.rutik.moringa.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    @Override
    Page<ProductEntity> findAll(Pageable pageable);
}
